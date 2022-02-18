package cl.robomatic.email.v1.clients.impl;


import cl.robomatic.email.v1.clients.SendGridApiClient;
import cl.robomatic.email.v1.dtos.applicationproperties.sendgrid.SendGridDto;
import cl.robomatic.email.v1.dtos.sendgrid.MailRequest;
import cl.robomatic.email.v1.dtos.sendgrid.MailResponse;
import cl.robomatic.email.v1.exceptions.messages.BadGatewayErrorCode;
import cl.robomatic.email.v1.utils.LogUtils;
import cl.robomatic.email.v1.exceptions.BadGatewayException;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class SendGridApiClientImpl implements SendGridApiClient {

	private Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();

	private static final int HTTP_STATUS_OK = 202;

	private static final String SODEXO_EMAIL_TYPE = "sodexo";

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private SendGridDto sendGridConf;

	/**
	 * Metodo que se comunica con API SendGrid para envío de mail.
	 *
	 * @param mailRequest El objeto de la peticion.
	 * @return MailResponse, status de envío.
	 */
	@Override
	public MailResponse sendMail(MailRequest mailRequest) {
		MailResponse mailResponse = null;
		try {
			String json = gson.toJson(mailRequest);
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			log.info("BearerAuth: {}",sendGridConf.getApi().getApikey());
			headers.setBearerAuth(sendGridConf.getApi().getApikey());
			HttpEntity<?> httpEntity = new HttpEntity<>(json, headers);
			String url = sendGridConf.getApi().getUrl();
			ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, httpEntity, String.class);
			log.info("Send Mail to [" + mailRequest.getPersonalizations().get(0).getTo().get(0).getEmail()
					+ "] - Api sendgrid: " + responseEntity.getStatusCode());
			if (responseEntity.getStatusCodeValue() == HTTP_STATUS_OK) {
				return MailResponse.builder().status("OK").personalizations(mailRequest.getPersonalizations()).build();
			}
		} catch (HttpStatusCodeException e) {
			throwError(StringUtils.isBlank(e.getResponseBodyAsString()) ? e.getMessage() : e.getResponseBodyAsString(),
					"502001");
		} catch (Exception e) {
			throwError(e.getMessage(), BadGatewayErrorCode.E502002.getCode());
		}
		return mailResponse;
	}

	/**
	 * Metodo que permite lanzar una excepcion de tipo BadGatewayException.
	 *
	 * @param messageError El mensaje de la excepcion.
	 * @param codeError    El codigo de la excepcion.
	 */
	private void throwError(String messageError, String codeError) {
		String error = LogUtils.formatObjectToJson("Mail Request", String.format("Api Error: %s", messageError));
		log.error(error);
		throw new BadGatewayException(codeError, messageError);
	}


}
