package cl.robomatic.email.v1.services;

import cl.robomatic.email.v1.dtos.applicationproperties.smtp.SmtpDto;
import cl.robomatic.email.v1.dtos.sendgrid.MailRequest;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;

@Slf4j
@Service
public class SendMailService implements MailService{

    @Autowired
    private SmtpDto smtpConfig;

    public boolean sendMail(MailRequest mailRequest) {

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setUsername(smtpConfig.getEmailUsername());
        mailSender.setPassword(smtpConfig.getEmailPassword());
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setDefaultEncoding(smtpConfig.getDefaultEncoding());

        Properties javaMailProps = new Properties();
        javaMailProps.setProperty("mail.smtp.starttls.enable", "true");
        javaMailProps.setProperty("mail.smtp.timeout", "25000");
        javaMailProps.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");
        javaMailProps.setProperty("mail.smtp.auth", "true");
        javaMailProps.setProperty("mail.smtp.Host", "smtp.gmail.com");
        javaMailProps.setProperty("mail.smtp.port", "587");
        javaMailProps.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        mailSender.setJavaMailProperties(javaMailProps);

        MimeMessage message = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            String[] to = mailRequest.getTo().split(",");
            helper.setTo(to);
            helper.setSubject(mailRequest.getSubject());
            helper.setText(Resources.toString(Resources.getResource("mail-template.html"), Charsets.UTF_8), true);

            //FileSystemResource res = new FileSystemResource(new File("c:/Sample.jpg"));
            //helper.addInline("identifier1234", res);

        } catch (MessagingException | IOException e) {
            log.error("Error sending mail: {}", e.getMessage());
            return false;
        }

        mailSender.send(message);

        return true;

    }

}
