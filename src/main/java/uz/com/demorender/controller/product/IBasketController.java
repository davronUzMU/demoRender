package uz.com.demorender.controller.product;

import org.springframework.web.bind.annotation.*;
import uz.com.demorender.payload.ApiResult;
import uz.com.demorender.payload.product.ProductResponseDTO;
import uz.com.demorender.utils.ApplicationConstants;

import java.util.List;

@RequestMapping(value = IBasketController.BATH_PATH)
public interface IBasketController {
    String BATH_PATH = ApplicationConstants.BASE_PATH + "/basket";

    String COUNT="/count";

    String SALARY="/salary";


    @PostMapping("/{id}")
    ApiResult<Boolean> add(@PathVariable Integer id);

    @GetMapping()
    ApiResult<List<ProductResponseDTO>> allProduct();

    @GetMapping(COUNT)
    ApiResult<Integer> count();

    @GetMapping(SALARY+"/{id}")
    ApiResult<Double> salary(@PathVariable Integer id,@RequestParam Integer numeric);

    @DeleteMapping()
    ApiResult<Boolean> allDelete();

    @DeleteMapping("/{id}")
    ApiResult<Boolean> onlyOneDelete(@PathVariable Integer id);

}
