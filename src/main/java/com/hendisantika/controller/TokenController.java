package com.hendisantika.controller;

import com.hendisantika.dto.OTP;
import com.hendisantika.dto.TempOTP;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-twilio-otp
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 14/03/22
 * Time: 08.10
 */
@Slf4j
@RestController
public class TokenController {
    @PostMapping("/otp")
    public ResponseEntity<String> ValidateToken(@RequestBody TempOTP otp) {

        int sentOTP = OTP.getOtp();
        log.info(sentOTP + ":" + otp.getOtp());
        if (sentOTP == otp.getOtp()) {
            return new ResponseEntity<>("Success otp", HttpStatus.OK);
        }
        return new ResponseEntity<>("failure", HttpStatus.UNAUTHORIZED);
    }
}
