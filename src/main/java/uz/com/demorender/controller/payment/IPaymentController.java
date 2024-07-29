package uz.com.demorender.controller.payment;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.com.demorender.payload.ApiResult;
import uz.com.demorender.payload.payment.PaymentRequest;
import uz.com.demorender.payload.payment.PaymentResponse;
import uz.com.demorender.utils.ApplicationConstants;

import javax.validation.Valid;


@RequestMapping(value = IPaymentController.BATH_PATH)
public interface IPaymentController {
    String BATH_PATH= ApplicationConstants.BASE_PATH+"/payment";

    @PostMapping("/create-payment")
    ApiResult<PaymentResponse> createPayment(@Valid @RequestBody PaymentRequest paymentRequest);

    @PostMapping("/edit-payment/{id}")
    ApiResult<PaymentResponse> edit(@Valid @PathVariable Integer id, @RequestBody PaymentRequest paymentRequest);
}
