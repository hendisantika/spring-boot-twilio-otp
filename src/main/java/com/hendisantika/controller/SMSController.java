package com.hendisantika.controller;

import com.hendisantika.dto.Sms;
import com.hendisantika.service.SmsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-twilio-otp
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 14/03/22
 * Time: 08.03
 */
@Slf4j
@RestController
@RequestMapping("api/otp")
public class SMSController {
    private final String TOPIC_DESTINATION = "/lesson/sms";
    @Autowired
    private SmsService service;
    @Autowired
    private SimpMessagingTemplate webSocket;

    //You can send SMS in verified Number
    @PostMapping()
    public ResponseEntity<Boolean> sendSMS(@RequestBody Sms sms) {
        try {
            log.info("hello");
            service.send(sms);
            log.info("hello");
        } catch (Exception e) {

            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        webSocket.convertAndSend(TOPIC_DESTINATION, getTimeStamp() + ": SMS has been sent!: " + sms.getTo());
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @PostMapping(value = "/sms-callback", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces =
            MediaType.APPLICATION_JSON_VALUE)
    public void smsCallback(@RequestBody MultiValueMap<String, String> map) {
        service.receive(map);
        webSocket.convertAndSend(TOPIC_DESTINATION, getTimeStamp() + ": Twilio has made a callback request! Here are " +
                "the contents: " + map.toString());
    }

    private String getTimeStamp() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
    }
}
