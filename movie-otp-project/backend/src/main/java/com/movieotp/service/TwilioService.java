package com.movieotp.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import jakarta.annotation.PostConstruct;

@Service
public class TwilioService {

    @Value("${twilio.accountSid:}")
    private String accountSid;

    @Value("${twilio.authToken:}")
    private String authToken;

    @Value("${twilio.phoneNumber:}")
    private String fromNumber;

    @PostConstruct
    public void init() {
        if (accountSid != null && !accountSid.isEmpty()) {
            Twilio.init(accountSid, authToken);
        }
    }

    public void sendSms(String toPhone, String text) {
        if (accountSid == null || accountSid.isEmpty()) {
            // Running in demo mode — print OTP to logs instead of sending SMS.
            System.out.println("[DEMO SMS] to=" + toPhone + " text=" + text);
            return;
        }
        Message.creator(new PhoneNumber(toPhone), new PhoneNumber(fromNumber), text).create();
    }
}
