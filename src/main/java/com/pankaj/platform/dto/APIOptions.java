package com.pankaj.platform.dto;

import com.pankaj.platform.domain.Blog;
import com.pankaj.platform.domain.ContactMe;

import java.io.InputStream;

/**
 * Created by pankajpardasani on 17/07/2016.
 */
public class APIOptions {

    private final Blog blogEntry;
    private final ContactMe contactDetails;
    private String documentName;
    private String documentType;
    private InputStream documentContent;
    private String documentIdentifier;

    private APIOptions(APIOptionsBuilder builder) {
        this.blogEntry = builder.blog;
        this.contactDetails = builder.contact;
        this.documentContent = builder.documentContent;
        this.documentName = builder.documentName;
        this.documentType = builder.documentType;
        this.documentIdentifier = builder.documentID;
    }

    public Blog getBlogEntry() {
        return blogEntry;
    }

    public ContactMe getContactDetails() {
        return contactDetails;
    }

    public String getDocumentName() {
        return documentName;
    }

    public String getDocumentType() {
        return documentType;
    }

    public InputStream getDocumentContent() {
        return documentContent;
    }

    public String getDocumentIdentifier() {
        return documentIdentifier;
    }

    public static class APIOptionsBuilder {
        private Blog blog;
        private ContactMe contact;
        private String documentName;
        private String documentType;
        private InputStream documentContent;
        private String documentID;


        public APIOptionsBuilder withBlogEntry(Blog blogEntry) {
            this.blog = blogEntry;
            return this;
        }

        public APIOptionsBuilder withContactDetails(ContactMe contactDetails) {
            this.contact = contactDetails;
            return this;
        }

        public APIOptionsBuilder withDocumentName(String documentName) {
            this.documentName = documentName;
            return this;
        }

        public APIOptionsBuilder withDocumentType(String documentType) {
            this.documentType = documentType;
            return this;
        }

        public APIOptionsBuilder withDocument(InputStream documentContent) {
            this.documentContent = documentContent;
            return this;
        }

        public APIOptionsBuilder withDocumentID(String documentID) {
            this.documentID = documentID;
            return this;
        }

        public APIOptions build() {
            return new APIOptions(this);
        }
    }
}
