package cl.robomatic.email.v1.dtos.applicationproperties;

import cl.robomatic.email.v1.dtos.applicationproperties.retry.RetryDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConstantsDto {

    private RetryDto retry;
    private String topic;

}
