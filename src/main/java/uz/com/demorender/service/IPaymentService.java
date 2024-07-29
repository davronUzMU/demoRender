package uz.com.demorender.service;

import uz.com.demorender.payload.ApiResult;
import uz.com.demorender.payload.payment.PaymentRequest;
import uz.com.demorender.payload.payment.PaymentResponse;

public interface IPaymentService {
    ApiResult<PaymentResponse> createPayment(PaymentRequest paymentRequest);

    ApiResult<PaymentResponse> edit(Integer id, PaymentRequest paymentRequest);

    Boolean editBillValue(Integer paymentId, Integer amount, Double prise);
}
