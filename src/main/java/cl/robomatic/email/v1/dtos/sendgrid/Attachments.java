package cl.robomatic.email.v1.dtos.sendgrid;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Attachments {
	private String content;
	private String type;
	private String filename;	
}
