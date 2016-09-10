package com.pankaj.platform.service;

import com.pankaj.platform.dto.APIOptions;
import org.springframework.stereotype.Service;

/**
 * Created by pankajpardasani on 10/09/2016.
 */

@Service
public interface ContactService {
    boolean accountContactDetails(APIOptions options);
}
