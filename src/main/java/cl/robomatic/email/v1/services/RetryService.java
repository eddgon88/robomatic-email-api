package cl.robomatic.email.v1.services;

import cl.robomatic.email.v1.dtos.retry.RetryResponse;
import cl.robomatic.email.v1.dtos.sendgrid.MailRequest;

import java.text.ParseException;

public interface RetryService {

    RetryResponse sendRetry(MailRequest mailRequest) throws ParseException;

}
