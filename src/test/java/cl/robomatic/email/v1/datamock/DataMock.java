package cl.robomatic.email.v1.datamock;

import cl.robomatic.email.v1.dtos.retry.RetryRequest;
import cl.robomatic.email.v1.dtos.retry.RetryResponse;
import cl.robomatic.email.v1.dtos.sendgrid.MailRequest;
import cl.robomatic.email.v1.dtos.sendgrid.MailResponse;
import cl.robomatic.email.v1.dtos.applicationproperties.ConstantsDto;
import cl.robomatic.email.v1.dtos.applicationproperties.retry.RetryDto;
import cl.robomatic.email.v1.dtos.applicationproperties.sendgrid.ApiDto;
import cl.robomatic.email.v1.dtos.applicationproperties.sendgrid.EmailDto;
import cl.robomatic.email.v1.dtos.applicationproperties.sendgrid.SendGridDto;
import cl.robomatic.email.v1.dtos.sendgrid.From;
import cl.robomatic.email.v1.dtos.sendgrid.Personalizations;
import cl.robomatic.email.v1.dtos.sendgrid.To;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;
import java.util.Collections;

public final class DataMock {

    private DataMock() {
    }


    public static ConstantsDto createConstantsDto() {
        return ConstantsDto.builder()
                .retry(getRetryDto())
                .topic("topic.test")
                .build();
    }

    public static RetryDto getRetryDto() {
        return RetryDto.builder()
                .datePattern("yyyyMMddHHmm")
                .minutesToAdd(5)
                .retryNumber(3)
                .url("http://pad-pdp-payments-gateway-service-retry/retry-service-internal/v1/retry")
                .build();
    }

    public static MailRequest getMailRequest() {
        return MailRequest.builder()
            .from(From.builder()
                .email("no-reply@klap.cl")
                .build())
            .personalizations(Arrays.asList(Personalizations.builder()
                .to(Arrays.asList(To.builder()
                    .email("test@klap.cl")
                    .build()))
                .dynamicTemplateData(Collections.singletonMap("key", "value"))
                .build()))
            .build();
    }

    public static String getStringMailRequest() {
        Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create();
        return gson.toJson(getMailRequest());
    }

    public static SendGridDto createSendGridDto() {
        return SendGridDto.builder()
                .email(EmailDto.builder()
                        .receiptFrom("test@klap.cl")
                        .receiptSubject("asunto")
                        .templateId("23242353524")
                        .build())
                .api(ApiDto.builder()
                        .url("dir.com")
                        .apikey("89644537564")
                        .build())
                .build();
    }

    public static MailResponse createMailResponse() {
        return MailResponse.builder()
                .status("complete")
                .personalizations(Arrays.asList(Personalizations.builder()
                    .to(Arrays.asList(To.builder()
                            .email("test@klap.cl")
                            .build()))
                    .dynamicTemplateData(Collections.singletonMap("key", "value"))
                    .build()))
                .build();
    }

    public static RetryRequest createRetryRequest() {
        return RetryRequest.builder()
                .data(getStringMailRequest())
                .topic("topic.test")
                .nextTry("202111041000")
                .build();
    }

    public static RetryResponse createRetryResponse() {
        return RetryResponse.builder()
                .retryId("86785678")
                .build();
    }

}
