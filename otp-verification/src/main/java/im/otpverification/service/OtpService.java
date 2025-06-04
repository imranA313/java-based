package im.otpverification.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.twilio.type.PhoneNumber;
import im.otpverification.config.TwilioConfig;
import im.otpverification.entity.AuthRequest;
import im.otpverification.util.JwtUtil;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class OtpService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtTokenUtil;
    @Autowired
    private UserDetailsService userService;
    @Autowired
    private TwilioConfig twilioConfig;
    @Autowired
    private ObjectMapper objectMapper;

    private static final Integer EXPIRE_MIN = 5;
    private LoadingCache<String, String> otpCache;

    public OtpService() {
        otpCache = CacheBuilder.newBuilder()
                .expireAfterWrite(EXPIRE_MIN, TimeUnit.MINUTES)
                .build(new CacheLoader<>() {
                    @Override
                    public String load(String s) {
                        return "";
                    }
                });
    }

    @SneakyThrows
    public String generateOtp(String phoneNo) {
        //generate OTP
        Map<String,Object> returnMap=new HashMap<>();
        PhoneNumber to = new PhoneNumber(phoneNo);
        PhoneNumber from = new PhoneNumber(twilioConfig.getTrialNumber());
        String otp = getRandomOTP(phoneNo);
        String otpMessage = "Dear Customer , Your OTP is " + otp + ". Use this otp to log in to Rapido Clone Application";


        try{
            returnMap.put("otp", otp);
            returnMap.put("status","success");
            returnMap.put("message","Otp sent successfully");
        }catch (Exception e){
            returnMap.put("status","failed");
            returnMap.put("message",e.getMessage());
        }

        return objectMapper.writeValueAsString(returnMap);
    }

    private String getRandomOTP(String phoneNo) {
        String otp = new DecimalFormat("000000")
                .format(new Random().nextInt(999999));
        otpCache.put(phoneNo, otp);
        return otp;
    }

    @SneakyThrows
    public String verifyOtp(AuthRequest authenticationRequest) {
        Map<String, Object> returnMap = new HashMap<>();
        try {
            //verify otp
            if (authenticationRequest.getOtp().equals(getCacheOtp(authenticationRequest.getPhoneNo()))) {
                String jwtToken = createAuthenticationToken(authenticationRequest);
                returnMap.put("status", "success");
                returnMap.put("message", "Otp verified successfully");
                returnMap.put("jwt", jwtToken);
                clearOtp(authenticationRequest.getPhoneNo());
            } else {
                returnMap.put("status", "success");
                returnMap.put("message", "Otp is either expired or incorrect");
            }

        } catch (Exception e) {
            returnMap.put("status", "failed");
            returnMap.put("message", e.getMessage());
        }

        return objectMapper.writeValueAsString(returnMap);
    }

    //get saved otp
    private String getCacheOtp(String key) {
        try {
            return otpCache.get(key);
        } catch (Exception e) {
            return "";
        }
    }

    //clear stored otp
    private void clearOtp(String key) {
        otpCache.invalidate(key);
    }

    public String createAuthenticationToken(AuthRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getPhoneNo(), "")
            );
        }
        catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }
        final UserDetails userDetails = userService.loadUserByUsername(authenticationRequest.getPhoneNo());
        return jwtTokenUtil.generateToken(userDetails);
    }
}
