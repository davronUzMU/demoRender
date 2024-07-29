package uz.com.demorender.controller.payment;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import uz.com.demorender.payload.ApiResult;
import uz.com.demorender.payload.payment.TransactionCardRequest;
import uz.com.demorender.payload.payment.TransactionCardResponse;
import uz.com.demorender.service.ITransactionService;

@RestController
@RequiredArgsConstructor
public class TransactionController implements ITransactionController{
    private final ITransactionService transactionService;
    @Override
    public ApiResult<TransactionCardResponse> buyTransaction(TransactionCardRequest transactionCardRequest, Integer id) {
        return transactionService.buyTransaction(transactionCardRequest,id);
    }

    @Override
    public ApiResult<TransactionCardResponse> balanceReplenishment(TransactionCardRequest transactionCardRequest) {
        return transactionService.balanceReplenishment(transactionCardRequest);
    }
}
