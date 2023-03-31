package com.example.teste_email.mail;

import com.example.teste_email.mail.BodyType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

@Slf4j
@Component
@PropertySource("classpath:messageSources.properties")
public class JavaMailService {

  //  @Value("${application.javamail.username}")
    private String username = "health_automation@outlook.com";

    //@Value("${application.javamail.password}")
    private String password = "@Mv20222";

   // @Value("${application.javamail.senderName}")
    private String senderName = "health_automation";

    //@Value("${application.javamail.smtp.host}")
    private String host = "smtp-mail.outlook.com";

   // @Value("${application.javamail.smtp.port}")
    private String port = "587";

   // @Value("${application.javamail.smtp.protocol}")
    private String protocol = "smtp";

    private void sendEmail(Email email) {

        email.setSendersName(senderName);

        try {

            Properties properties = new Properties();
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.transport.protocol", protocol);
            properties.put("mail.smtp.host", host);
            properties.put("mail.smtp.port", port);
           // properties.put("mail.smtp.ssl.enable", "true");
            properties.put("mail.debug", "true");
            properties.put("mail.smtp.socketFactory.class",
                    "javax.net.ssl.SSLSocketFactory");

            Session session = Session.getInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

            Address[] recipients = new Address[0];

            try {
                recipients = InternetAddress.parse(email.getRecipients());
            } catch (AddressException e) {
                log.error("Could not parse address [" + email.getRecipients() + "].",
                        HttpStatus.BAD_REQUEST);
            }

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username, email.getSendersName()));
            message.setRecipients(Message.RecipientType.TO, recipients);
            message.setSubject(email.getSubject());

            Multipart multipart = new MimeMultipart();

            MimeBodyPart body = new MimeBodyPart();
            if (Boolean.TRUE.equals(email.getIsHtmlBody()))
                body.setContent(email.getBody(), "text/html; charset=utf-8");
            else
                body.setText(email.getBody());

            multipart.addBodyPart(body);

/*            if (email.getAttachments() != null) {
                email.getAttachments().forEach(a -> {
                    try {
                        MimeBodyPart attachment = new MimeBodyPart();

                        attachment.setDataHandler(new DataHandler(new ByteArrayDataSource(a.getBase64File(),
                                ContentTypes.getContentType(a.getFileExtension()))));
                        attachment.setFileName(a.getFileName());

                        multipart.addBodyPart(attachment);
                    } catch (MessagingException | IOException e) {
                        log.error(HttpStatus.BAD_REQUEST,
                                "Could not add attachment [" + a.getFileName() + a.getFileExtension() + "].");
                    }
                });
            }*/

            message.setContent(multipart);

            Transport.send(message);

        } catch (MessagingException | UnsupportedEncodingException e) {
            log.error("Email sending failed. " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    public void sendEmail(final BodyType bodyType, final List<String> emails, final String subject,
                          final Map<String, String> bodyVariables) {

        String body = EmailBodyUtil.getBodyHtml(bodyType);

        for (final Entry<String, String> bodyVariable : bodyVariables.entrySet()) {
            body = body.replace(bodyVariable.getKey(), bodyVariable.getValue());
        }

        final Email email = new Email.Builder().body(body, true).subject(subject).addAllRecipientsEmails(emails)
                .build();

        new Thread(() -> sendEmail(email), "Email sender thread").start();

    }
}
