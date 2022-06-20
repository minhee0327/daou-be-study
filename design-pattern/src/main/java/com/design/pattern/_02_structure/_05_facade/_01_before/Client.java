package com.design.pattern._02_structure._05_facade._01_before;

import com.design.pattern._02_structure._05_facade._02_after.EmailMessage;
import com.design.pattern._02_structure._05_facade._02_after.EmailSender;
import com.design.pattern._02_structure._05_facade._02_after.EmailSettings;

public class Client {
    public static void main(String[] args) {
        EmailSettings emailSettings = new EmailSettings();
        emailSettings.setHost("127.0.0.1");

        EmailMessage emailMessage = new EmailMessage();
        emailMessage.setFrom("keesun");
        emailMessage.setTo("keesun@whiteship.me");
        emailMessage.setCc("일남");
        emailMessage.setSubject("오징어 게임");
        emailMessage.setText("밖은 더 지옥이더라고..");

        EmailSender emailSender = new EmailSender(emailSettings);
        emailSender.sendEmail(emailMessage);

    }
}
