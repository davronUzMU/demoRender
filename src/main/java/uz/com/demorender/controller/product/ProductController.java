package uz.com.demorender.controller.product;

import org.springframework.web.bind.annotation.RestController;
import uz.com.demorender.payload.ApiResult;
import uz.com.demorender.payload.product.ProductRequestDTO;
import uz.com.demorender.payload.product.ProductResponseDTO;
import uz.com.demorender.service.IProductService;

import java.util.List;
@RestController
public class ProductController implements IProductController{

    private final IProductService iProductService;

    public ProductController(IProductService iProductService) {
        this.iProductService = iProductService;
    }

    @Override
    public ApiResult<ProductResponseDTO> add(ProductRequestDTO productRequestDTO) {
        return iProductService.add(productRequestDTO);
    }

    @Override
    public ApiResult<ProductResponseDTO> edit(ProductRequestDTO productRequestDTO, Integer id) {
        return iProductService.edit(productRequestDTO,id);
    }

    @Override
    public ApiResult<Boolean> delete(Integer id) {
        return iProductService.delete(id);
    }

    @Override
    public ApiResult<ProductResponseDTO> one(Integer id) {
        return iProductService.one(id);
    }

    @Override
    public ApiResult<List<ProductResponseDTO>> list() {
        return iProductService.list();
    }
}
