package uz.com.demorender.service;


import uz.com.demorender.payload.ApiResult;
import uz.com.demorender.payload.category.CategoryRequestDTO;
import uz.com.demorender.payload.category.CategoryResponseDTO;

import java.util.List;

public interface ICategoryService {
    ApiResult<CategoryResponseDTO> add(CategoryRequestDTO category);

    ApiResult<List<CategoryResponseDTO>> list();

    ApiResult<CategoryResponseDTO> edit(Integer id, CategoryRequestDTO categoryDTO);

    ApiResult<Boolean> delete(Integer id);

    ApiResult<CategoryResponseDTO> one(Integer id);
}