package com.pankaj.platform.dto;

import com.pankaj.platform.domain.Blog;
import com.pankaj.platform.domain.ContactMe;

import java.io.InputStream;
import java.util.Map;

/**
 * Created by pankajpardasani on 17/07/2016.
 */
public class APIOptions {

    private final Blog blogEntry;
    private final ContactMe contactDetails;
    private final String documentName;
    private final String documentType;
    private final InputStream documentContent;
    private final String documentIdentifier;
    private final Map<String, String> documentMetaData;

    private APIOptions(APIOptionsBuilder builder) {
        this.blogEntry = builder.blog;
        this.contactDetails = builder.contact;
        this.documentContent = builder.documentContent;
        this.documentName = builder.documentName;
        this.documentType = builder.documentType;
        this.documentIdentifier = builder.documentID;
        this.documentMetaData = builder.documentMetaData;
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

    public Map<String, String> getDocumentMetaData() {
        return documentMetaData;
    }

    public static class APIOptionsBuilder {
        private Blog blog;
        private ContactMe contact;
        private String documentName;
        private String documentType;
        private InputStream documentContent;
        private String documentID;
        private Map<String, String> documentMetaData;


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

        public APIOptionsBuilder withDocumentMetaData(Map<String, String> documentMetaData) {
            this.documentMetaData = documentMetaData;
            return this;
        }

        public APIOptions build() {
            return new APIOptions(this);
        }
    }
}
