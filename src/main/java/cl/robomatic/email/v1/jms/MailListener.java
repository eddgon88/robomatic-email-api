package cl.robomatic.email.v1.jms;

import cl.robomatic.email.v1.dtos.sendgrid.MailRequest;
import cl.robomatic.email.v1.services.MailService;
import cl.robomatic.email.v1.exceptions.InternalErrorException;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import static cl.robomatic.email.v1.exceptions.messages.InternalErrorCode.E500001;

@Slf4j
@Component
public class MailListener {

    private Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create();

    @Autowired
    MailService mailService;

    @JmsListener(destination = "${constants.topic}", containerFactory = "defaultJmsFactory")
    public void sendMail(final String message) {
        log.info("Listening a message from activeMQ: {}", message);
        try {
            mailService.sendMail(this.gson.fromJson(message, MailRequest.class));
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new InternalErrorException(E500001);
        }
    }

}
