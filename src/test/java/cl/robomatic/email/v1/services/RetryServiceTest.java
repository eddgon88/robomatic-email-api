package cl.robomatic.email.v1.services;

import cl.robomatic.email.v1.clients.RetryApiClient;
import cl.robomatic.email.v1.datamock.DataMock;
import cl.robomatic.email.v1.dtos.applicationproperties.ConstantsDto;
import cl.robomatic.email.v1.dtos.retry.RetryRequest;
import cl.robomatic.email.v1.dtos.retry.RetryResponse;
import cl.robomatic.email.v1.dtos.sendgrid.MailRequest;
import cl.robomatic.email.v1.exceptions.BadGatewayException;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

@RunWith(MockitoJUnitRunner.Silent.class)
public class RetryServiceTest {

    @InjectMocks
    RetryServiceImpl retryService;

    @Mock
    RetryApiClient retryApiClient;

    @Mock
    ConstantsDto constants;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        initMocks();
    }

    @Test
    public void sendRetry() {
        MailRequest mailRequest = DataMock.getMailRequest();
        RetryResponse retryResponse = DataMock.createRetryResponse();
        doReturn(retryResponse).when(retryApiClient).sendRetry(any(RetryRequest.class));
        RetryResponse response = retryService.sendRetry(mailRequest);
        Assertions.assertEquals(response, retryResponse);
    }

    @Test(expected = BadGatewayException.class)
    public void sendRetryException(){
        MailRequest mailRequest = DataMock.getMailRequest();
        doThrow(BadGatewayException.class).when(retryApiClient).sendRetry(any(RetryRequest.class));
        retryService.sendRetry(mailRequest);
    }

    private void initMocks() {
        ConstantsDto constantsDto = DataMock.createConstantsDto();
        doReturn(constantsDto.getRetry()).when(this.constants).getRetry();
    }
}