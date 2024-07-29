package uz.com.demorender.controller.product;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import uz.com.demorender.payload.ApiResult;
import uz.com.demorender.payload.product.ProductResponseDTO;
import uz.com.demorender.service.IBasketService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BasketController implements IBasketController{

    private  final IBasketService iBasketService;

    @Override
    public ApiResult<Boolean> add(Integer id) {
        return iBasketService.add(id);
    }

    @Override
    public ApiResult<List<ProductResponseDTO>> allProduct() {
        return iBasketService.allProduct();
    }

    @Override
    public ApiResult<Integer> count() {
        return iBasketService.count();
    }

    @Override
    public ApiResult<Double> salary(Integer id, Integer numeric) {
        return iBasketService.salary(id,numeric);
    }


    @Override
    public ApiResult<Boolean> allDelete() {
        return iBasketService.allDelete();
    }

    @Override
    public ApiResult<Boolean> onlyOneDelete(Integer id) {
        return iBasketService.onlyOneDelete(id);
    }
}
