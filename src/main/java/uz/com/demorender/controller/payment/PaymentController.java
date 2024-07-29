package uz.com.demorender.controller.payment;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import uz.com.demorender.payload.ApiResult;
import uz.com.demorender.payload.payment.PaymentRequest;
import uz.com.demorender.payload.payment.PaymentResponse;
import uz.com.demorender.service.IPaymentService;

@RestController
@RequiredArgsConstructor
public class PaymentController implements IPaymentController{

    private final IPaymentService paymentService;
    @Override
    public ApiResult<PaymentResponse> createPayment(PaymentRequest paymentRequest) {
        return paymentService.createPayment(paymentRequest);
    }

    @Override
    public ApiResult<PaymentResponse> edit(Integer id, PaymentRequest paymentRequest) {
        return paymentService.edit(id,paymentRequest);
    }

}
