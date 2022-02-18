package cl.robomatic.email.v1.dtos.applicationproperties.jms;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JmsDto {
    private String brokerUr;
    private String username;
    private String password;
}
