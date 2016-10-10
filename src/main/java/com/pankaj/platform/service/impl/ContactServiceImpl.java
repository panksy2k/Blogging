package com.pankaj.platform.service.impl;

import com.pankaj.platform.domain.ContactMe;
import com.pankaj.platform.dto.APIOptions;
import com.pankaj.platform.dto.EmailOptions;
import com.pankaj.platform.exception.BloggingBusinessException;
import com.pankaj.platform.repository.ContactRepository;
import com.pankaj.platform.service.ContactService;
import com.pankaj.platform.service.EmailService;
import com.pankaj.platform.util.ObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

/**
 * Created by pankajpardasani on 10/09/2016.
 */
@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private TemplateEngine htmlTemplateEngine;

    @Autowired
    private EmailService emailService;

    @Override
    public boolean accountContactDetails(APIOptions options) {
        ContactMe contactMe = options.getContactDetails();
        ObjectUtil.checkNotNull(contactMe, "Could not find contact details before persisting!");

        final Context ctx = new Context(new Locale.Builder().setLanguage("en").setRegion("UK").build());
        ctx.setVariable("name", "Pankaj");
        ctx.setVariable("subscriptionDate", new Date());
        ctx.setVariable("hobbies", Arrays.asList("Cinema", "Sports", "Music"));

        // Create the HTML body using Thymeleaf
        final String htmlContent = this.htmlTemplateEngine.process("contact-me-email", ctx);

        EmailOptions emailOptions = new EmailOptions.EmailOptionsBuilder()
                .withFromAddress("pankaj.d.p@gmail.com")
                .withSubject("Simple Sample Email")
                .withToAddress("pankaj.d.p@gmail.com")
                .build();

        try {
            emailService.sendSimpleEmail(emailOptions, ByteBuffer.wrap(htmlContent.getBytes("UTF-8")));
        }
        catch(UnsupportedEncodingException | MessagingException e) {
            throw new BloggingBusinessException(e);
        }

        return true;
    }
}
