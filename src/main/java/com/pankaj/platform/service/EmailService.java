package com.pankaj.platform.service;

import com.pankaj.platform.dto.EmailOptions;
import javax.mail.MessagingException;
import java.nio.ByteBuffer;


/**
 * Created by pardasap on 10/10/2016.
 */
public interface EmailService {
    void sendSimpleEmail(final EmailOptions options, final ByteBuffer message) throws MessagingException;
}
