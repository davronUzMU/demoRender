package uz.com.demorender.controller.payment;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.com.demorender.payload.ApiResult;
import uz.com.demorender.payload.payment.TransactionCardRequest;
import uz.com.demorender.payload.payment.TransactionCardResponse;
import uz.com.demorender.utils.ApplicationConstants;

import javax.validation.Valid;

@RequestMapping(value = ITransactionController.BATH_PATH)
public interface ITransactionController {

    String BATH_PATH= ApplicationConstants.BASE_PATH+"/transaction";

    @PostMapping("/buy-product/{id}")
    ApiResult<TransactionCardResponse> buyTransaction(@Valid @RequestBody TransactionCardRequest transactionCardRequest, @PathVariable Integer id);

    @PostMapping("/balance-replenishment")
    ApiResult<TransactionCardResponse> balanceReplenishment(@Valid @RequestBody TransactionCardRequest transactionCardRequest);

}
