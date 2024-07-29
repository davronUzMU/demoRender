package uz.com.demorender.controller.user;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.com.demorender.payload.ApiResult;
import uz.com.demorender.payload.EmailDTO;
import uz.com.demorender.utils.ApplicationConstants;
@RequestMapping(value = IEmailController.BATH_PATH)
public interface IEmailController {
    String BATH_PATH= ApplicationConstants.BASE_PATH+"/email";

    @PostMapping("/send-emails")
    ApiResult<String> sendEmail(@RequestBody EmailDTO emailDTO);

    ApiResult<String> sendMailWithAttachment(@RequestBody EmailDTO emailDTO);
}
