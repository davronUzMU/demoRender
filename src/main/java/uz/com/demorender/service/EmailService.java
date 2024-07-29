package uz.com.demorender.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import uz.com.demorender.payload.ApiResult;
import uz.com.demorender.payload.EmailDTO;

@Service
@RequiredArgsConstructor
public class EmailService implements IEmailService {


    private  final JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;


    @Override
    public ApiResult<String> sendEmail(EmailDTO emailDTO) {
        try {
            SimpleMailMessage mailMessage
                    = new SimpleMailMessage();
            mailMessage.setFrom(sender);
            mailMessage.setTo(emailDTO.getRecipient());
            mailMessage.setText(emailDTO.getMsgBody());
            mailMessage.setSubject(emailDTO.getSubject());
            javaMailSender.send(mailMessage);
            return ApiResult.successResponse("success ");
        } catch (Exception e) {
            return ApiResult.successResponse("error ?");
        }
    }

    @Override
    public ApiResult<String> sendMailWithAttachment(EmailDTO emailDTO) {
        return null;
    }
}
