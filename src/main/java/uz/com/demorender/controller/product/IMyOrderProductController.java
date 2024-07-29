package uz.com.demorender.controller.product;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.com.demorender.payload.ApiResult;
import uz.com.demorender.payload.product.ProductResponseDTO;
import uz.com.demorender.utils.ApplicationConstants;

import java.util.List;

@RequestMapping(value = IMyOrderProductController.BATH_PATH)
public interface IMyOrderProductController{
   String BATH_PATH= ApplicationConstants.BASE_PATH+"/my-order-product";

   String COUNT="/count";

   @GetMapping("/{id}")
   ApiResult<Boolean> add(@PathVariable Integer id);

   @GetMapping()
   ApiResult<List<ProductResponseDTO>> list();

   @DeleteMapping("/{id}")
   ApiResult<Boolean> delete(@PathVariable Integer id);

   @GetMapping(COUNT)
   ApiResult<Integer> count();


   @GetMapping("/allDelete")
   ApiResult<Boolean> allDelete();

}
