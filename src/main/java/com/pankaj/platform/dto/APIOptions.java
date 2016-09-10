package com.pankaj.platform.dto;

import com.pankaj.platform.domain.Blog;
import com.pankaj.platform.domain.ContactMe;

/**
 * Created by pankajpardasani on 17/07/2016.
 */
public class APIOptions {

    private final Blog blogEntry;
    private final ContactMe contactDetails;

    private APIOptions(APIOptionsBuilder builder) {
        this.blogEntry = builder.blog;
        this.contactDetails = builder.contact;
    }

    public Blog getBlogEntry() {
        return blogEntry;
    }

    public ContactMe getContactDetails() {
        return contactDetails;
    }

    public static class APIOptionsBuilder {
        private Blog blog;
        private ContactMe contact;

        public APIOptionsBuilder() {
        }

        public APIOptionsBuilder withBlogEntry(Blog blogEntry) {
            this.blog = blogEntry;
            return this;
        }

        public APIOptionsBuilder withContactDetails(ContactMe contactDetails) {
            this.contact = contactDetails;
            return this;
        }

        public APIOptions build() {
            return new APIOptions(this);
        }
    }
}
