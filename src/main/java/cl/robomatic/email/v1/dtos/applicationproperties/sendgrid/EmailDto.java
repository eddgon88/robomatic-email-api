package cl.robomatic.email.v1.dtos.applicationproperties.sendgrid;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmailDto {
	private String receiptFrom;
	private String receiptSubject;
	private String templateId;
}
