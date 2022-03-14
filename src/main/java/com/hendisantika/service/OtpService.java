package com.hendisantika.service;

import com.google.common.cache.LoadingCache;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-twilio-otp
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 14/03/22
 * Time: 08.17
 */
@Service
public class OtpService {
    //cache based on username and OPT MAX 8
    private static final Integer EXPIRE_MINS = 5;

    private LoadingCache<String, Integer> otpCache;
}
