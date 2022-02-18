package cl.robomatic.email.v1.services;

import cl.robomatic.email.v1.dtos.retry.RetryResponse;
import cl.robomatic.email.v1.dtos.sendgrid.MailRequest;
import cl.robomatic.email.v1.clients.RetryApiClient;
import cl.robomatic.email.v1.dtos.applicationproperties.ConstantsDto;
import cl.robomatic.email.v1.dtos.retry.RetryRequest;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Slf4j
@Service
public class RetryServiceImpl implements RetryService {

    private Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create();

    @Autowired
    private RetryApiClient retryApiClient;

    @Autowired
    private ConstantsDto constants;

    @Override
    public RetryResponse sendRetry(MailRequest mailRequest) {
        log.info("Sending a mail to retry: {}", mailRequest);
        RetryResponse retryResponse = null;
        final String data = this.gson.toJson(mailRequest);
        String date = formatDate(Calendar.MINUTE, constants.getRetry().getMinutesToAdd());
        RetryRequest retryRequest = RetryRequest.builder()
                .topic(constants.getTopic())
                .data(data)
                .nextTry(date)
                .build();
        try {
            retryResponse = this.retryApiClient.sendRetry(retryRequest);
        }catch (Exception e) {
            log.error("Error sending retry: {}", e.getMessage());
            throw e;
        }
        return retryResponse;
    }

    private String formatDate(Integer keyToAdd, Integer valueToAdd) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(constants.getRetry().getDatePattern());
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(keyToAdd, valueToAdd);
        return simpleDateFormat.format(calendar.getTime());
    }
}
