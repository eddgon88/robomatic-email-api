package cl.robomatic.email.v1.configurations;

import cl.robomatic.email.v1.dtos.applicationproperties.sendgrid.SendGridDto;
import cl.robomatic.email.v1.dtos.applicationproperties.ConstantsDto;
import cl.robomatic.email.v1.dtos.applicationproperties.jms.JmsDto;
import cl.robomatic.email.v1.dtos.applicationproperties.smtp.SmtpDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationPropertiesConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "spring.activemq")
    public JmsDto jmsConfig() {
        return new JmsDto();
    }

    @Bean
    @ConfigurationProperties(prefix = "constants")
    public ConstantsDto constantsConfig() {
        return new ConstantsDto();
    }

    @Bean
    @ConfigurationProperties(prefix = "sendgrid")
    public SendGridDto sendGridConfig() {
        return new SendGridDto();
    }

    @Bean
    @ConfigurationProperties(prefix = "smtp")
    public SmtpDto smtpConfig() {
        return new SmtpDto();
    }
}
