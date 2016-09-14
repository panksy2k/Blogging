/*
package com.pankaj.platform.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

*/
/**
 * Created by pardasap on 18/07/2016.
 *//*

@Configuration
public class JavaMailConfig {
    @Value("${mail.smtp}")
    private String smtp;

    @Value("${mail.port}")
    private int port;

    @Value("${mail.encoding}")
    private String mailEncoding;

    @Value("${mail.protocol}")
    private String mailProtocol;

    @Value("${mail.transport.protocol}")
    private String mailTransportProtocol;

    @Value("${mail.smtp.auth}")
    private String isSMTPAuthticated;

    @Value("${mail.smtp.starttls.enable}")
    private String isSMTPTLSEnabled;

    @Bean(name = "mailSender")
    public JavaMailSenderImpl mailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        Properties javaMailProperties = new Properties();
        javaMailProperties.setProperty("mail.smtp.auth", isSMTPAuthticated);
        javaMailProperties.setProperty("mail.smtp.starttls.enable", isSMTPTLSEnabled);
        javaMailProperties.setProperty("mail.debug", "true");
        javaMailProperties.setProperty("mail.debug.auth", "true");

        mailSender.setJavaMailProperties(javaMailProperties);
        mailSender.setHost(smtp);
        mailSender.setPort(port);
        mailSender.setProtocol(mailProtocol);
        mailSender.setDefaultEncoding(mailEncoding);

        return mailSender;
    }
}
*/
