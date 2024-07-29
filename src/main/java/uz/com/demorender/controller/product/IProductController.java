package uz.com.demorender.controller.product;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import uz.com.demorender.payload.ApiResult;
import uz.com.demorender.payload.product.ProductRequestDTO;
import uz.com.demorender.payload.product.ProductResponseDTO;
import uz.com.demorender.utils.ApplicationConstants;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(value = IProductController.BATH_PATH)
@Validated
public interface IProductController {
    String BATH_PATH= ApplicationConstants.BASE_PATH+"/product";

    @PostMapping
    ApiResult<ProductResponseDTO> add(@Valid @RequestBody ProductRequestDTO productRequestDTO);

    @PostMapping("/{id}")
    ApiResult<ProductResponseDTO> edit(@Valid @RequestBody ProductRequestDTO productRequestDTO ,@PathVariable Integer id);

    @DeleteMapping("/{id}")
    ApiResult<Boolean> delete(@PathVariable Integer id);

    @GetMapping("/{id}")
    ApiResult<ProductResponseDTO> one(@PathVariable Integer id);

    @GetMapping
    ApiResult<List<ProductResponseDTO>> list();

}
