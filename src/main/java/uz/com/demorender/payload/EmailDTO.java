package uz.com.demorender.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class EmailDTO {

    private String recipient;

    private String msgBody;

    private String subject;

    private String attachment;
}
