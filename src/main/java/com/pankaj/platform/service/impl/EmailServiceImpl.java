package com.pankaj.platform.service.impl;

import com.pankaj.platform.dto.EmailOptions;
import com.pankaj.platform.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.nio.ByteBuffer;

@Service
public class EmailServiceImpl implements EmailService {
    private static final Logger LOG = LoggerFactory.getLogger(EmailServiceImpl.class);

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendSimpleEmail(final EmailOptions options, final ByteBuffer message) {
        try {
            mailSender.send(getMimeMessage(options, message));
        } catch (Exception e) {
            LOG.error("Error while sending email -- reason {}", e.getMessage());
        }
    }

    private MimeMessage getMimeMessage(final EmailOptions parameters, final ByteBuffer attachmentContent) throws MessagingException, IOException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom(parameters.getFrom());
        helper.setTo(parameters.getTo().split(","));
        helper.setSubject(parameters.getSubject());
        helper.setText(new String(attachmentContent.array()));

        return mimeMessage;
    }
}
