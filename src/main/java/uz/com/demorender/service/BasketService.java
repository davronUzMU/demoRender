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
public class BasketService implements IBasketService {

    private final ProductRepository productRepository;

    private final MessageSource messageSource;

    private final ProductService productService;

    List<ProductResponseDTO> productResponseDTOList = new ArrayList<>();

    @Override
    public ApiResult<Boolean> add(Integer id) {
        checkExistsProductId(id);
        Product product = productRepository.findById(id).orElseThrow((() -> AppException.appThrow(messageSource.getMessage("",
                null,
                LocaleContextHolder.getLocale()))));
        return ApiResult.successResponse(productResponseDTOList.
                add(productService.
                        convertProductToProductResponse(product)));
    }


    @Override
    public ApiResult<List<ProductResponseDTO>> allProduct() {
        return ApiResult.successResponse(productResponseDTOList);
    }


    @Override
    public ApiResult<Boolean> allDelete() {
        productResponseDTOList.clear();
        return ApiResult.successResponse(true);
    }

    @Override
    public ApiResult<Boolean> onlyOneDelete(Integer id) {
        int number = -1;
        for (ProductResponseDTO productResponseDTO : productResponseDTOList) {
            if (Objects.equals(productResponseDTO.getId(), id)) {
                number++;
            }
        }
        if (number == -1) {
            return ApiResult.successResponse(false);
        } else {
            productResponseDTOList.remove(number);
        }
        return ApiResult.successResponse(true);
    }

    @Override
    public ApiResult<Integer> count() {
        return ApiResult.successResponse(productResponseDTOList.size());
    }

    @Override
    public ApiResult<Double> salary(Integer id, Integer numeric) {
        checkExistsProductId(id);
        Double prise = productsPriseResponse(id, numeric);
        return ApiResult.successResponse(prise);
    }

    private Double productsPriseResponse(Integer id, Integer numeric) {
        Product product = productRepository.findById(id).orElseThrow(() -> AppException.appThrow(messageSource.getMessage("Wrong",
                null,
                LocaleContextHolder.getLocale())));
        if(numeric==0)
            throw AppException.appThrow("There isn't this product");

        if(product.getNumberOfProducts()<numeric)
            throw AppException.appThrow("kkkkkkk");

        double prise;
        prise=product.getPrise()*numeric;
        return prise;
    }


    private void checkExistsProductId(Integer id) {
        boolean existsById = productRepository.existsById(id);
        if (!existsById)
            throw AppException.appThrow("This id isn't existent");
    }
}
