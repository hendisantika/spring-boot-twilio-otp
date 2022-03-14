package com.hendisantika.dto;

import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-twilio-otp
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 14/03/22
 * Time: 08.02
 */
@Data
public class OTP {
    static int otp;

    public static int getOtp() {
        return otp;
    }

    public static void setOtp(int otp) {
        OTP.otp = otp;
    }
}
