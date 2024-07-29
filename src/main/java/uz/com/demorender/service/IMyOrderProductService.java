package uz.com.demorender.service;

import uz.com.demorender.payload.ApiResult;
import uz.com.demorender.payload.product.ProductResponseDTO;

import java.util.List;

public interface IMyOrderProductService {
    ApiResult<Boolean> add(Integer id);

    ApiResult<List<ProductResponseDTO>> list();

    ApiResult<Boolean> delete(Integer id);

    ApiResult<Boolean> allDelete();

    ApiResult<Integer> count();
}
