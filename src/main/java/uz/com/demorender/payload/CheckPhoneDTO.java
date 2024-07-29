package uz.com.demorender.payload;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CheckPhoneDTO {

    private boolean register;
}
