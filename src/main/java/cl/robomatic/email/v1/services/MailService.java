package cl.robomatic.email.v1.services;

import cl.robomatic.email.v1.dtos.sendgrid.MailRequest;
import cl.robomatic.email.v1.dtos.sendgrid.MailResponse;

import java.text.ParseException;

public interface MailService {

    boolean sendMail(MailRequest mailRequest) throws ParseException;

}
