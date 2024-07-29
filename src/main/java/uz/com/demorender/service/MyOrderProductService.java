package uz.com.demorender.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import uz.com.demorender.exceptions.AppException;
import uz.com.demorender.model.Product;
import uz.com.demorender.payload.ApiResult;
import uz.com.demorender.payload.product.ProductResponseDTO;
import uz.com.demorender.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MyOrderProductService implements IMyOrderProductService{

    private final ProductRepository productRepository;

    private final MessageSource messageSource;

    private final ProductService productService;

    List<ProductResponseDTO> productResponseDTOArrayList = new ArrayList<>();

    @Override
    public ApiResult<Boolean> add(Integer id) {
        checkExistsProductId(id);
        Product product = productRepository.findById(id).orElseThrow((() -> AppException.appThrow(messageSource.getMessage("",
                null,
                LocaleContextHolder.getLocale()))));
        return ApiResult.successResponse(productResponseDTOArrayList.
                add(productService.
                        convertProductToProductResponse(product)));
    }


    @Override
    public ApiResult<List<ProductResponseDTO>> list() {
        return ApiResult.successResponse(productResponseDTOArrayList);
    }

    @Override
    public ApiResult<Boolean> delete(Integer id) {
        int number=-1;
        for (ProductResponseDTO productResponseDTO : productResponseDTOArrayList) {
            if (Objects.equals(productResponseDTO.getId(), id)) {
                number++;
            }
        }
        if (number == -1) {
            return ApiResult.successResponse(false);
        } else {
            productResponseDTOArrayList.remove(number);
        }
        return ApiResult.successResponse(true);
    }

    @Override
    public ApiResult<Boolean> allDelete() {
        productResponseDTOArrayList.clear();
        return ApiResult.successResponse(true);
    }

    @Override
    public ApiResult<Integer> count() {
        return ApiResult.successResponse(productResponseDTOArrayList.size());
    }
    private void checkExistsProductId(Integer id) {
        boolean existsById = productRepository.existsById(id);
        if (!existsById)
            throw AppException.appThrow("This id isn't existent");
    }
}
