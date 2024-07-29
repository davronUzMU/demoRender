package uz.com.demorender.service;

import uz.com.demorender.payload.ApiResult;
import uz.com.demorender.payload.product.ProductResponseDTO;

import java.util.List;

public interface IBasketService {
    ApiResult<Boolean> add(Integer id);

    ApiResult<List<ProductResponseDTO>> allProduct();

    ApiResult<Boolean> allDelete();

    ApiResult<Boolean> onlyOneDelete(Integer id);

    ApiResult<Integer> count();

    ApiResult<Double> salary(Integer id, Integer numeric);
}
