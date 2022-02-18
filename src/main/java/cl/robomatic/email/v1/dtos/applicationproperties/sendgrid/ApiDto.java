package cl.robomatic.email.v1.dtos.applicationproperties.sendgrid;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiDto {
	private String apikey;
	private String url;
}
