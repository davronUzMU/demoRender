package uz.com.demorender.controller.user;

import org.springframework.web.bind.annotation.RestController;
import uz.com.demorender.payload.ApiResult;
import uz.com.demorender.payload.EmailDTO;
import uz.com.demorender.service.IEmailService;

@RestController
public class EmailController implements IEmailController{

    private final IEmailService emailService;

    public EmailController(IEmailService emailService) {
        this.emailService = emailService;
    }

    @Override
    public ApiResult<String> sendEmail(EmailDTO emailDTO) {
        return emailService.sendEmail(emailDTO);
    }

    @Override
    public ApiResult<String> sendMailWithAttachment(EmailDTO emailDTO) {
        return emailService.sendMailWithAttachment(emailDTO);
    }
}
