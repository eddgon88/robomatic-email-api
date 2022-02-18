package cl.robomatic.email.v1.dtos.applicationproperties.retry;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RetryDto {
    private String url;
    private String datePattern;
    private Integer minutesToAdd;
    private Integer retryNumber;
}
