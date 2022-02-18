package cl.robomatic.email.v1.clients.impl;

import cl.robomatic.email.v1.clients.RetryApiClient;
import cl.robomatic.email.v1.dtos.applicationproperties.ConstantsDto;
import cl.robomatic.email.v1.dtos.retry.RetryRequest;
import cl.robomatic.email.v1.dtos.retry.RetryResponse;
import cl.robomatic.email.v1.exceptions.BadGatewayException;
import cl.robomatic.email.v1.utils.LogUtils;
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
public class RetryApiClientImpl implements RetryApiClient {

    private Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create();
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ConstantsDto constants;

    /**
     * Metodo que se comunica con API Retry para envío de reintento.
     *
     * @param retryRequest El objeto de la peticion.
     * @return RetryResponse, status de envío.
     */
    @Override
    public RetryResponse sendRetry(RetryRequest retryRequest) {
        RetryResponse retryResponse = null;
        ResponseEntity<RetryResponse> retryClientResponse = null;
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            log.info("body: {}", retryRequest);

            final String body = gson.toJson(retryRequest);

            HttpEntity<?> httpEntity = new HttpEntity<>(body, headers);

            String retryClientUrl = constants.getRetry().getUrl();

            retryClientResponse = restTemplate.postForEntity(retryClientUrl, httpEntity, RetryResponse.class);
            log.info("retry sent to: {}", retryClientUrl);
            retryResponse = retryClientResponse.getBody();
        } catch (HttpStatusCodeException e) {
            log.error(e.getMessage());
            throwError(StringUtils.isBlank(e.getResponseBodyAsString()) ? e.getMessage() : e.getResponseBodyAsString(), "502001");
        } catch (Exception e) {
            log.error(e.getMessage());
            throwError(e.getMessage(), "502002");
        }
        return retryResponse;
    }

    /**
     * Metodo que permite lanzar una excepcion de tipo BadGatewayException.
     *
     * @param messageError El mensaje de la excepcion.
     * @param codeError    El codigo de la excepcion.
     */
    private void throwError(String messageError, String codeError) {
        String error = LogUtils.formatObjectToJson("Ldp-api Client", String.format("Api Error: %s", messageError));
        log.error(error);
        throw new BadGatewayException(codeError, messageError);
    }
}
