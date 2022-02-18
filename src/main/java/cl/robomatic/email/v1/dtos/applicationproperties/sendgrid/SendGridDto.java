package cl.robomatic.email.v1.dtos.applicationproperties.sendgrid;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SendGridDto {

	private EmailDto email;
	private ApiDto api;
}
