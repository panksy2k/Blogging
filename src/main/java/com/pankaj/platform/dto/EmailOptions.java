package com.pankaj.platform.dto;

public class EmailOptions {
    private final String from;
    private final String to;
    private final String subject;
    private final String emailText;
    private final String attachmentName;

    private EmailOptions(EmailOptionsBuilder builder) {
        this.from = builder.from;
        this.to = builder.to;
        this.subject = builder.subject;
        this.emailText = builder.emailText;
        this.attachmentName = builder.attachmentName;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getSubject() {
        return subject;
    }

    public String getEmailText() {
        return emailText;
    }

    public String getAttachmentName() {
        return attachmentName;
    }

    public static class EmailOptionsBuilder {
        private String from, to, subject, emailText, attachmentName;

        public EmailOptionsBuilder() {}

        public EmailOptionsBuilder withFromAddress(String from) {
            this.from = from;
            return this;
        }

        public EmailOptionsBuilder withToAddress(String to) {
            this.to = to;
            return this;
        }

        public EmailOptionsBuilder withSubject(String subject) {
            this.subject = subject;
            return this;
        }

        public EmailOptionsBuilder withEmailText(String text) {
            this.emailText = text;
            return this;
        }

        public EmailOptionsBuilder withEmailAttachmentName(String nameOfAttachmentFile) {
            this.attachmentName = nameOfAttachmentFile;
            return this;
        }

        public EmailOptions build() {
            return new EmailOptions(this);
        }
    }
}
