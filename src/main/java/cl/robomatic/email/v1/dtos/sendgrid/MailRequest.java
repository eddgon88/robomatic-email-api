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
public class MailRequest {
	private List<Personalizations> personalizations;
	private String to;
	private String body;
	private From from;
	private String subject;
	private String templateId;
	private String type;
	private List<Attachments> attachments;
	private Integer retry;
}
