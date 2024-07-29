package uz.com.demorender.controller.category;

import org.springframework.web.bind.annotation.RestController;
import uz.com.demorender.payload.ApiResult;
import uz.com.demorender.payload.category.CategoryRequestDTO;
import uz.com.demorender.payload.category.CategoryResponseDTO;
import uz.com.demorender.service.ICategoryService;

import java.util.List;


@RestController
public class CategoryController implements ICategoryController {

    private final ICategoryService categoryService;

    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @Override
    public ApiResult<CategoryResponseDTO> add(CategoryRequestDTO category) {
        return categoryService.add(category);
    }

    @Override
    public ApiResult<List<CategoryResponseDTO>> list() {
        return categoryService.list();
    }

    @Override
    public ApiResult<CategoryResponseDTO> edit(Integer id, CategoryRequestDTO categoryDTO) {
        return categoryService.edit(id, categoryDTO);
    }

    @Override
    public ApiResult<Boolean> delete(Integer id) {
        return categoryService.delete(id);
    }

    @Override
    public ApiResult<CategoryResponseDTO> one(Integer id) {
        return categoryService.one(id);
    }

}
