package cl.robomatic.email.v1.controllers;


import cl.robomatic.email.v1.commons.FunctionCaller;
import cl.robomatic.email.v1.dtos.sendgrid.MailRequest;
import cl.robomatic.email.v1.services.SendMailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.UnaryOperator;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequestMapping("/email-api/v1/")
public class SendMailController {

    @Autowired
    private SendMailService mailService;

    @Autowired
    FunctionCaller functionCaller;

    @PostMapping(value = "/send", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createLdp(@RequestBody final MailRequest mailRequest) {
        UnaryOperator<Object> function = req -> mailService.sendMail((MailRequest) req);
        return functionCaller.callFunction(mailRequest, function, HttpStatus.CREATED);
    }

}
