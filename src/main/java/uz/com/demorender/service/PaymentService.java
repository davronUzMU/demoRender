package uz.com.demorender.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import uz.com.demorender.exceptions.AppException;
import uz.com.demorender.model.Payment;
import uz.com.demorender.model.TransactionCard;
import uz.com.demorender.payload.ApiResult;
import uz.com.demorender.payload.payment.PaymentRequest;
import uz.com.demorender.payload.payment.PaymentResponse;
import uz.com.demorender.repository.PaymentRepository;
import uz.com.demorender.repository.TransactionCardRepository;

import java.util.*;


@Service
@RequiredArgsConstructor
public class PaymentService implements IPaymentService{

    private final MessageSource messageSource;

    private final PaymentRepository paymentRepository;

    private final TransactionCardRepository transactionCardRepository;

    @Override
    public ApiResult<PaymentResponse> createPayment(PaymentRequest paymentRequest) {
        checkIsObject(paymentRequest);
        Payment.PaymentBuilder paymentBuilder = Payment.builder();

        paymentBuilder.nameCard(paymentRequest.getNameCard());

        checkNumber(paymentRequest.getNumber());
        paymentBuilder.number(paymentRequest.getNumber());

        checkAddress(paymentRequest.getAddress());
        paymentBuilder.address(paymentRequest.getAddress());

        checkBillValue(paymentRequest.getBillValue());
        paymentBuilder.billValue(paymentRequest.getBillValue());

        checkNumberCard(paymentRequest.getCardNumber());
        paymentBuilder.cardNumber(paymentRequest.getCardNumber());

        checkCardHolder(paymentRequest.getCardHolder());
        paymentBuilder.cardHolder(paymentRequest.getCardHolder());

        checkDateValue(paymentRequest.getDateValue());
        paymentBuilder.dateValue(paymentRequest.getDateValue());

        paymentBuilder.transactionCardSet(null);

        Payment payment = paymentRepository.save(paymentBuilder.build());
        return ApiResult.successResponse(new PaymentResponse(payment.getId(),
                payment.getNameCard(),payment.getNumber(),payment.getAddress(),payment.getBillValue(),payment.getCardNumber(),payment.getCardHolder(),payment.getDateValue(),payment.getTransactionCardSet()));
    }

    @Override
    public ApiResult<PaymentResponse> edit(Integer id, PaymentRequest paymentRequest) {
        Payment payment = paymentRepository.findById(id).orElseThrow();

        Payment.PaymentBuilder paymentBuilder = Payment.builder();

        payment.setNameCard(paymentRequest.getNameCard());

        payment.setNumber(paymentRequest.getNumber());

        payment.setAddress(paymentRequest.getAddress());

        payment.setBillValue(paymentRequest.getBillValue());

        payment.setCardNumber(paymentRequest.getCardNumber());

        payment.setCardHolder(paymentRequest.getCardHolder());

        payment.setDateValue(paymentRequest.getDateValue());

        List<TransactionCard> all = transactionCardRepository.findAll();

        Set<TransactionCard> paymentChildrenAllByIdTransaction=new HashSet<>();
        for (TransactionCard card : all) {
            if(Objects.equals(card.getPayment().getId(),id)){
                paymentChildrenAllByIdTransaction.add(card);
            }
        }
        paymentBuilder.transactionCardSet(paymentChildrenAllByIdTransaction);

        paymentBuilder.transactionCardSet(null);

        paymentRepository.save(payment);
        return ApiResult.successResponse(new PaymentResponse(payment.getId(),
                payment.getNameCard(),payment.getNumber(),payment.getAddress(),payment.getBillValue(),payment.getCardNumber(),payment.getCardHolder(),payment.getDateValue(),payment.getTransactionCardSet()));
    }

    @Override
    public Boolean editBillValue(Integer paymentId, Integer amount, Double prise) {
        Payment payment = paymentRepository.findById(paymentId).orElseThrow(()->AppException.appThrow("Wrong"));
        payment.setBillValue(payment.getBillValue()-amount*prise);
        paymentRepository.save(payment);
        return true;
    }


    private void checkDateValue(String dateValue) {
        if(!(dateValue.length()==5 || dateValue.contains("/")))
            throw AppException.appThrow(messageSource.getMessage(
                    "WRONG_INFORMATION",
                    null,
                    LocaleContextHolder.getLocale()
            ));
    }

    private void checkCardHolder(String cardHolder) {
        if(Objects.isNull(cardHolder))
            throw AppException.appThrow(messageSource.getMessage(
                    "WRONG_INFORMATION",
                    null,
                    LocaleContextHolder.getLocale()
            ));
    }

    private void checkNumber(String number) {
        if(!Objects.equals(number.length(),9))
            throw AppException.appThrow(messageSource.getMessage(
                    "WRONG_INFORMATION",
                    null,
                    LocaleContextHolder.getLocale()
            ));
    }

    private void checkBillValue(Double billValue) {
        if(Objects.isNull(billValue) || billValue<0)
            throw AppException.appThrow(messageSource.getMessage(
                    "WRONG_INFORMATION",
                    null,
                    LocaleContextHolder.getLocale()
            ));
    }

    private void checkAddress(String address) {
        if(Objects.isNull(address))
            throw AppException.appThrow(messageSource.getMessage(
                    "WRONG_INFORMATION",
                    null,
                    LocaleContextHolder.getLocale()
            ));
    }

    private void checkNumberCard(String cardNumber) {
        if(!Objects.equals(cardNumber.length(),16))
            throw AppException.appThrow(messageSource.getMessage(
                    "WRONG_INFORMATION",
                    null,
                    LocaleContextHolder.getLocale()
            ));
    }

    private void checkIsObject(Object locationDTO) {
        if(Objects.isNull(locationDTO))
            throw AppException.appThrow(messageSource.getMessage(
                    "WRONG_INFORMATION",
                    null,
                    LocaleContextHolder.getLocale()
            ));
    }
}

