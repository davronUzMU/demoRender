package uz.com.demorender.service;

import uz.com.demorender.payload.ApiResult;
import uz.com.demorender.payload.payment.TransactionCardRequest;
import uz.com.demorender.payload.payment.TransactionCardResponse;

public interface ITransactionService {
    ApiResult<TransactionCardResponse> buyTransaction(TransactionCardRequest transactionCardRequest, Integer id);

    ApiResult<TransactionCardResponse> balanceReplenishment(TransactionCardRequest transactionCardRequest);
}
