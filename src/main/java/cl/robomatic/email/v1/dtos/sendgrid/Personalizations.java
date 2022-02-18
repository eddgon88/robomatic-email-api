package cl.robomatic.email.v1.dtos.sendgrid;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Personalizations {
    private List<To> to;
    private Map<String,String> dynamicTemplateData;
    private String subject;
}
