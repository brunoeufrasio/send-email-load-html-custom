package com.example.teste_email.mail;

import java.util.Collections;
import java.util.List;

import com.example.teste_email.dto.AttachmentDTO;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Email {

    private final String recipients;
    private String sendersName;
    private final String subject;
    private final String body;
    private final Boolean isHtmlBody;
    private final List<AttachmentDTO> attachments;

    public static class Builder {
        private String recipients;
        private String sendersName;
        private String subject;
        private String body;
        private Boolean isHtmlBody;
        private List<AttachmentDTO> attachments;

        public Builder addAllRecipientsEmails(List<String> recipientsEmails) {
            recipientsEmails.forEach(e -> {
                if (this.recipients != null)
                    this.recipients += "," + e;
                else
                    this.recipients = e;
            });

            return this;
        }

        public Builder addRecipientEmail(String recipientEmail) {
            if (this.recipients == null)
                this.recipients = recipientEmail;
            else
                this.recipients += "," + recipientEmail;

            return this;
        }

        public Builder sendersName(String sendersName) {
            this.sendersName = sendersName;
            return this;
        }

        public Builder subject(String subject) {
            this.subject = subject;
            return this;
        }

        public Builder body(String body, Boolean isHtmlBody) {
            this.body = body;
            this.isHtmlBody = isHtmlBody;
            return this;
        }

        public Builder addAllAttachments(List<AttachmentDTO> attachments) {
            if (this.attachments == null)
                this.attachments = attachments;
            else
                this.attachments.addAll(attachments);
            return this;
        }

        public Builder addAttachment(AttachmentDTO attachmentDTO) {
            if (this.attachments == null)
                this.attachments = Collections.singletonList(attachmentDTO);
            else
                this.attachments.add(attachmentDTO);
            return this;
        }

        public Email build() {
            return new Email(this);
        }
    }

    private Email(Builder builder) {
        this.recipients = builder.recipients;
        this.sendersName = builder.sendersName;
        this.subject = builder.subject;
        this.body = builder.body;
        this.isHtmlBody = builder.isHtmlBody;
        this.attachments = builder.attachments;
    }

    public void setSendersName(final String sendersName) {
        this.sendersName = sendersName;
    }

}
