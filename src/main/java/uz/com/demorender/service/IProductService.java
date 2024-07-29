package uz.com.demorender.service;

import uz.com.demorender.payload.ApiResult;
import uz.com.demorender.payload.product.ProductRequestDTO;
import uz.com.demorender.payload.product.ProductResponseDTO;

import java.util.List;

public interface IProductService {
    ApiResult<ProductResponseDTO> add(ProductRequestDTO productRequestDTO);

    ApiResult<ProductResponseDTO> edit(ProductRequestDTO productRequestDTO, Integer id);

    ApiResult<Boolean> delete(Integer id);

    ApiResult<ProductResponseDTO> one(Integer id);

    ApiResult<List<ProductResponseDTO>> list();
    Boolean editNumberOfProduct(Integer id,Integer numberOfProduct);
}
