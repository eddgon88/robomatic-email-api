package cl.robomatic.email.v1.dtos.utils;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Builder
@Getter
@Setter
public class Trace {
	private String title;
	private Long orderId;
    private String virtualId;
    private String referenceId;
	private String message;
	private Map<String, Object> customs;
	private String traceError;
}
