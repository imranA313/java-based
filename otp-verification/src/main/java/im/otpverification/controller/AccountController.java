package im.otpverification.controller;

import im.otpverification.dto.LoginDTO;
import im.otpverification.dto.SignupDTO;
import im.otpverification.dto.SuccessResponse;
import im.otpverification.dto.UserDTO;
import im.otpverification.entity.User;
import im.otpverification.mapper.AppMapper;
import im.otpverification.security.TokenProvider;
import im.otpverification.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.text.MessageFormat;
import java.util.List;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
public class AccountController{

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final TokenProvider tokenProvider;

    @GetMapping("/user")
    public ResponseEntity<SuccessResponse> getAllUser() {
        List<UserDTO> users = userService.getUsers().stream().map(AppMapper::copyUserEntityToDto).toList();
        return new ResponseEntity<>(new SuccessResponse(users, MessageFormat.format("{0} result found", users.size())), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<SuccessResponse> register(@Valid @RequestBody SignupDTO userDTO) {
        User user = AppMapper.copyUserDtoToEntity(userDTO);
        var encodePassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodePassword);

        User newUser = userService.save(user);

        return ResponseEntity.ok(new SuccessResponse(AppMapper.copyUserEntityToDto(newUser), "register Successfully"));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<SuccessResponse> authenticateUser(@Valid @RequestBody LoginDTO loginDTO) {

        var authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.username(), loginDTO.password()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.generateToken(authentication);

        return ResponseEntity.ok(new SuccessResponse(jwt, "Login Successfully"));
    }

}
