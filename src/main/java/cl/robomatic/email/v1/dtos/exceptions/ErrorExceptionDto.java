package cl.robomatic.email.v1.dtos.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorExceptionDto {
    private String code;
    private String message;
    private HttpStatus httpStatus;
}
