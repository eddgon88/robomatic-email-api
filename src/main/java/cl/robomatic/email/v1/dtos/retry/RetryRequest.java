package cl.robomatic.email.v1.dtos.retry;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RetryRequest {

    private String topic;
    private String data;
    private String nextTry;
    private String status;

}
