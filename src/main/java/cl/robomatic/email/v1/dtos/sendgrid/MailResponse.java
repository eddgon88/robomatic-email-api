package cl.robomatic.email.v1.dtos.sendgrid;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MailResponse {
	
	private String status;
	private List<Personalizations> personalizations;

}
