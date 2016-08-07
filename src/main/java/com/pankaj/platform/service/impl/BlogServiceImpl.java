package com.pankaj.platform.service.impl;

import com.pankaj.platform.dto.APIOptions;
import com.pankaj.platform.repository.BlogRepository;
import com.pankaj.platform.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by pankajpardasani on 17/07/2016.
 */
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public void addNewBlogEntry(APIOptions options) {

    }
}
