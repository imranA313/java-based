package im.otpverification.controller;

import im.otpverification.entity.AuthRequest;
import im.otpverification.service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/client/auth/")
public class AuthenticationController {

    @Autowired
    private OtpService otpService;

    @RequestMapping({ "ping" })
    public String ping(){
        return "Application is running...!";
    }

    @RequestMapping(value = "requestOtp/{phoneNo}",method = RequestMethod.GET)
    public ResponseEntity<Object> getOtp(@PathVariable String phoneNo){
        String otpGenerateResponse = otpService.generateOtp(phoneNo);
        return new ResponseEntity<>(otpGenerateResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "verifyOtp",method = RequestMethod.POST)
    public ResponseEntity<Object> verifyOtp(@RequestBody AuthRequest authenticationRequest){
        String otpVerificationResponse = otpService.verifyOtp(authenticationRequest);
        return new ResponseEntity<>(otpVerificationResponse, HttpStatus.OK);
    }

}
