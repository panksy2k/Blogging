package com.pankaj.platform.service.impl;

import com.pankaj.platform.domain.ContactMe;
import com.pankaj.platform.dto.APIOptions;
import com.pankaj.platform.repository.ContactRepository;
import com.pankaj.platform.service.ContactService;
import com.pankaj.platform.util.ObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by pankajpardasani on 10/09/2016.
 */
@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactRepository contactRepository;

    @Override
    public boolean accountContactDetails(APIOptions options) {
        ContactMe contactMe = options.getContactDetails();
        ObjectUtil.checkNotNull(contactMe, "Could not find contact details before persisting!");

        contactMe = contactRepository.save(contactMe);

        return (contactMe.getId() != 0 ? true : false);
    }
}
