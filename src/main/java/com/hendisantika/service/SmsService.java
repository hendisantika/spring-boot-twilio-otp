package com.hendisantika.service;

import com.hendisantika.dto.OTP;
import com.hendisantika.dto.Sms;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-twilio-otp
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 14/03/22
 * Time: 07.59
 */
@Slf4j
@Component
public class SmsService {
    private final String ACCOUNT_SID = "AC1272336dfaf920cf19319a0b06280b7f";

    private final String AUTH_TOKEN = "043f16a4bb78aae55f3b1e424d03d651";

    private final String FROM_NUMBER = "+14043417638";

    public void send(Sms sms) throws ParseException {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        int min = 100000;
        int max = 999999;
        int number = (int) (Math.random() * (max - min + 1) + min);

        String msg = "Your OTP - " + number + " please verify this OTP in your Application by Hendi Santika " +
                "https://linktr.ee/hendisantika";

        Message message = Message.creator(new PhoneNumber(sms.getTo()), new PhoneNumber(FROM_NUMBER), msg)
                .create();

        Date myDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = sdf.parse(myDate.toString());
        long millis = date.getTime();
        log.info("Date Time: " + millis);
        OTP.setOtp(number);
        log.info("Here is my id:" + message.getSid());// Unique resource ID created to manage this transaction
    }

    public void receive(MultiValueMap<String, String> smsCallBack) {

    }
}
