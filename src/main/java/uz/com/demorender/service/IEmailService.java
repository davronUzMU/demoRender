package uz.com.demorender.service;

import uz.com.demorender.payload.ApiResult;
import uz.com.demorender.payload.EmailDTO;

public interface IEmailService {
    ApiResult<String> sendEmail(EmailDTO emailDTO);

    ApiResult<String> sendMailWithAttachment(EmailDTO emailDTO);
}
