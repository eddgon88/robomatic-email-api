package cl.robomatic.email.v1.clients;

import cl.robomatic.email.v1.dtos.sendgrid.MailRequest;
import cl.robomatic.email.v1.dtos.sendgrid.MailResponse;

public interface SendGridApiClient {
	 /**
     * Metodo que se comunica con API SendGrid para envío de mail.
     *
     * @param mailRequest El objeto de la peticion.
     * @return MailResponse, status de envío.
     */
	MailResponse sendMail(MailRequest mailRequest);
}
