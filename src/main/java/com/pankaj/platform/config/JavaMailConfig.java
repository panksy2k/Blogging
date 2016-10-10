package com.pankaj.platform.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class JavaMailConfig {
    @Value("${mail.server.host}")
    private String smtp;

    @Value("${mail.server.port}")
    private int port;

    @Value("${mail.encoding}")
    private String mailEncoding;

    @Value("${mail.server.protocol}")
    private String mailProtocol;

    @Value("${mail.smtp.auth}")
    private String isSMTPAuthticated;

    @Value("${mail.smtp.starttls.enable}")
    private String isSMTPTLSEnabled;

    @Value("${mail.server.username}")
    private String userName;

    @Value("${mail.server.password}")
    private String password;

    @Bean(name = "mailSender")
    public JavaMailSender mailSender() {
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
        mailSender.setUsername(userName);
        mailSender.setPassword(password);

        return mailSender;
    }
}
