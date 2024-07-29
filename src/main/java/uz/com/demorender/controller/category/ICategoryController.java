package uz.com.demorender.controller.category;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import uz.com.demorender.payload.ApiResult;
import uz.com.demorender.payload.category.CategoryRequestDTO;
import uz.com.demorender.payload.category.CategoryResponseDTO;
import uz.com.demorender.utils.ApplicationConstants;

import java.util.List;

@RequestMapping(value = ICategoryController.BASE_PATH)
public interface ICategoryController {
    String BASE_PATH = ApplicationConstants.BASE_PATH + "/category";


    @PostMapping
    ApiResult<CategoryResponseDTO> add(@Valid @RequestBody CategoryRequestDTO category);

    @GetMapping
    ApiResult<List<CategoryResponseDTO>> list();

    @PutMapping("/{id}")
    ApiResult<CategoryResponseDTO> edit(@PathVariable Integer id,
                                        @RequestBody CategoryRequestDTO categoryDTO);

    @DeleteMapping("/{id}")
    ApiResult<Boolean> delete(@PathVariable Integer id);

    @GetMapping("/{id}")
    ApiResult<CategoryResponseDTO> one(@PathVariable Integer id);

}