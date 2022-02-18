package cl.robomatic.email.v1.jms;

import cl.robomatic.email.v1.datamock.DataMock;
import cl.robomatic.email.v1.dtos.sendgrid.MailRequest;
import cl.robomatic.email.v1.services.MailService;
import cl.robomatic.email.v1.exceptions.InternalErrorException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.text.ParseException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@RunWith(MockitoJUnitRunner.Silent.class)
public class MailListenerTest {

    @InjectMocks
    private MailListener mailListener;

    @Mock
    private MailService mailService;

    @Test
    public void sendMail() throws ParseException {
        String data = DataMock.getStringMailRequest();
        mailListener.sendMail(data);
        verify(mailService, times(1)).sendMail(any(MailRequest.class));
        verifyNoMoreInteractions(mailService);
    }

    @Test(expected = InternalErrorException.class)
    public void sendMailException() throws ParseException {
        String data = DataMock.getStringMailRequest();
        doThrow(ParseException.class).when(mailService).sendMail(any(MailRequest.class));
        mailListener.sendMail(data);
    }


}