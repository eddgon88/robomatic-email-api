package cl.robomatic.email.v1.dtos.utils;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ExceptionTrace {
	private String message;
	private String stackTrace;
}
