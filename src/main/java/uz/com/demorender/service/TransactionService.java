package uz.com.demorender.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.com.demorender.exceptions.AppException;
import uz.com.demorender.model.Payment;
import uz.com.demorender.model.Product;
import uz.com.demorender.model.TransactionCard;
import uz.com.demorender.payload.ApiResult;
import uz.com.demorender.payload.payment.TransactionCardRequest;
import uz.com.demorender.payload.payment.TransactionCardResponse;
import uz.com.demorender.repository.PaymentRepository;
import uz.com.demorender.repository.ProductRepository;
import uz.com.demorender.repository.TransactionCardRepository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class TransactionService implements ITransactionService {

    private final ProductRepository productRepository;

    private final MessageSource messageSource;

    private final PaymentRepository paymentRepository;

    private final TransactionCardRepository transactionCardRepository;

    private final IProductService productService;

    private final IPaymentService paymentService;

    @Override
    @Transactional
    public ApiResult<TransactionCardResponse> buyTransaction(TransactionCardRequest transactionCardRequest, Integer id) {
        checkIsObject(transactionCardRequest);
        Product product = productRepository.findById(id).orElseThrow(() -> AppException.appThrow(messageSource.getMessage("WRONG_INFORMATION",
                null,
                LocaleContextHolder.getLocale())));
        checkProduct(product);
        checkAmount(transactionCardRequest, product);
        checkPrise(transactionCardRequest.getPaymentId(), product, transactionCardRequest.getAmount());
        TransactionCard.TransactionCardBuilder transactionCardBuilder = getTransactionCardBuilderMake(transactionCardRequest, product);

        TransactionCard transactionCard = transactionCardRepository.save(transactionCardBuilder.build());

        return ApiResult.successResponse(new TransactionCardResponse(transactionCard.getId(),

                transactionCard.getAmount(),
                transactionCard.getServiceId(),
                transactionCard.getTransactionId(),
                transactionCard.getPhoneNumber(),
                transactionCard.getState(),
                transactionCard.getCreatedAt(),
                transactionCard.getPayment().getId(),
                transactionCard.getTransactionTime()
        ));
    }

    private TransactionCard.TransactionCardBuilder getTransactionCardBuilderMake(TransactionCardRequest transactionCardRequest, Product product) {
        TransactionCard.TransactionCardBuilder transactionCardBuilder = TransactionCard.builder();
        transactionCardBuilder.amount(transactionCardRequest.getAmount());
        Boolean editNumberOfProduct = productService.editNumberOfProduct(product.getId(), transactionCardRequest.getAmount());
        Boolean editBillValue = paymentService.editBillValue(transactionCardRequest.getPaymentId(), transactionCardRequest.getAmount(), product.getPrise());
        Long serviceId = generatorServiceId();
        transactionCardBuilder.serviceId(serviceId);
        Long transactionId = generatorTransactionId();
        transactionCardBuilder.transactionId(transactionId);
        transactionCardBuilder.phoneNumber(transactionCardRequest.getPhoneNumber());
        transactionCardBuilder.state(transactionCardRequest.getState());
        transactionCardBuilder.createdAt(Timestamp.valueOf(LocalDateTime.now()));
        transactionCardBuilder.payment(paymentRepository.findById(transactionCardRequest.getPaymentId()).
                orElseThrow(()->AppException.appThrow("Wrong information")));
        if (editNumberOfProduct && editBillValue) {
            transactionCardBuilder.transactionTime(Timestamp.valueOf(LocalDateTime.now()));
        }
        return transactionCardBuilder;
    }

    private Long generatorTransactionId() {
        Random random = new Random();
        long transactionId = random.nextLong();
        transactionId = Math.abs(transactionId) % 100000000000000L;
        List<TransactionCard> all = transactionCardRepository.findAll();
        for (TransactionCard card : all) {
            if (Objects.equals(card.getTransactionId(), transactionId))
                generatorTransactionId();
        }
        return transactionId;
    }

    private Long generatorServiceId() {
        Random random=new Random();
        long serviceId = random.nextLong();
        serviceId = Math.abs(serviceId) % 1000000000000L;
        List<TransactionCard> all = transactionCardRepository.findAll();
        for (TransactionCard card : all) {
            if (Objects.equals(card.getTransactionId(),serviceId))
                generatorServiceId();
        }
        return serviceId;
    }

    private void checkPrise(Integer paymentId, Product product, Integer amount) {
        Payment payment = paymentRepository.findById(paymentId).orElseThrow();
        if (product.getPrise() * amount > payment.getBillValue())
            throw AppException.appThrow(messageSource.getMessage(
                    "WRONG_INFORMATION",
                    null,
                    LocaleContextHolder.getLocale()
            ));
    }

    private void checkAmount(TransactionCardRequest transactionCardRequest, Product product) {
        if (transactionCardRequest.getAmount() > product.getNumberOfProducts())
            throw AppException.appThrow("wrong information");

    }

    private void checkProduct(Product product) {
        if (product.getNumberOfProducts() == 0)
            throw AppException.appThrow(messageSource.getMessage(
                    "WRONG_INFORMATION",
                    null,
                    LocaleContextHolder.getLocale()
            ));
    }

    private void checkIsObject(Object locationDTO) {
        if (Objects.isNull(locationDTO))
            throw AppException.appThrow(messageSource.getMessage(
                    "WRONG_INFORMATION",
                    null,
                    LocaleContextHolder.getLocale()
            ));
    }

    @Override
    public ApiResult<TransactionCardResponse> balanceReplenishment(TransactionCardRequest transactionCardRequest) {
        return null;
    }
}
