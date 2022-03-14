package com.hendisantika.controller;

import com.hendisantika.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-twilio-otp
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 14/03/22
 * Time: 08.03
 */
@RestController
public class SMSController {
    private final String TOPIC_DESTINATION = "/lesson/sms";
    @Autowired
    private SmsService service;
    @Autowired
    private SimpMessagingTemplate webSocket;
}
