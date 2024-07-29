package uz.com.demorender.controller.product;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import uz.com.demorender.payload.ApiResult;
import uz.com.demorender.payload.product.ProductResponseDTO;
import uz.com.demorender.service.IMyOrderProductService;

import java.util.List;
@RestController
@RequiredArgsConstructor
public class MyOrderProductController implements IMyOrderProductController{

    private final IMyOrderProductService iMyOrderProductService;
    @Override
    public ApiResult<Boolean> add(Integer id) {
        return iMyOrderProductService.add(id);
    }

    @Override
    public ApiResult<List<ProductResponseDTO>> list() {
        return iMyOrderProductService.list();
    }

    @Override
    public ApiResult<Boolean> delete(Integer id) {
        return iMyOrderProductService.delete(id);
    }

    @Override
    public ApiResult<Integer> count() {
        return iMyOrderProductService.count();
    }

    @Override
    public ApiResult<Boolean> allDelete() {
        return iMyOrderProductService.allDelete();
    }
}
