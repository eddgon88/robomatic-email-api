package cl.robomatic.email.v1.clients;

import cl.robomatic.email.v1.dtos.retry.RetryResponse;
import cl.robomatic.email.v1.dtos.retry.RetryRequest;

public interface RetryApiClient {

    RetryResponse sendRetry(RetryRequest retryRequest);

}
