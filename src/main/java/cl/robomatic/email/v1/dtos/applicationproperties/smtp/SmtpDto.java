package cl.robomatic.email.v1.dtos.applicationproperties.smtp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SmtpDto {

    private String emailHost;
    private String emailUsername;
    private String emailPassword;
    private String defaultEncoding;
    private Integer port;
    private String protocol;
}
