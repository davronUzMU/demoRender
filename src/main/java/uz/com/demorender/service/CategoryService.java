package uz.com.demorender.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import uz.com.demorender.exceptions.AppException;
import uz.com.demorender.model.Category;
import uz.com.demorender.payload.ApiResult;
import uz.com.demorender.payload.category.CategoryRequestDTO;
import uz.com.demorender.payload.category.CategoryResponseDTO;
import uz.com.demorender.repository.CategoryRepository;
import uz.com.demorender.repository.ManufactureRepository;

import java.util.HashSet;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {

    private final CategoryRepository categoryRepository;

    private final MessageSource messageSource;

    private final ManufactureRepository manufactureRepository;

    private final IManufactureService manufactureService;


    @Override
    public ApiResult<CategoryResponseDTO> add(CategoryRequestDTO categoryDTO) {
        checkRequiredFields(categoryDTO);
        boolean existsByParentIdAndName =
                categoryRepository.existsByParentIdAndName(
                        categoryDTO.getParentId(),
                        categoryDTO.getName());
        if (existsByParentIdAndName)
            throw AppException.appThrow(messageSource.getMessage(
                    "CATEGORY_WITH_THIS_PARENT_ID_ALREADY_EXISTS",
                    null,
                    LocaleContextHolder.getLocale()
            ));

        Category.CategoryBuilder categoryBuilder = Category.builder();
        categoryBuilder.name(categoryDTO.getName());
        categoryBuilder.url(categoryDTO.getUrl());
        categoryBuilder.parent(getParentCategoryById(categoryDTO.getParentId()));
        categoryBuilder.manufactures(new HashSet<>(manufactureRepository.findAllById(categoryDTO.getManufactures())));
        return ApiResult.successResponse(
                convertCategoryToCategoryResponseDTO(
                        categoryRepository.save(categoryBuilder.build())));
    }


    @Override
    public ApiResult<List<CategoryResponseDTO>> list() {
        return ApiResult.successResponse(categoryRepository.findAll()
                .stream()
                .map(this::convertCategoryToCategoryResponseDTO)
                .collect(Collectors.toList()));
    }


    @Override
    public ApiResult<CategoryResponseDTO> edit(Integer id, CategoryRequestDTO categoryDTO) {
        Category category = categoryRepository.findById(id).orElseThrow();
        category.setName(categoryDTO.getName());
        category.setUrl(categoryDTO.getUrl());
        category.setParent(getParentCategoryById(categoryDTO.getParentId()));
        category.setManufactures(new HashSet<>(manufactureRepository.findAllById(categoryDTO.getManufactures())));
        return ApiResult.successResponse(convertCategoryToCategoryResponseDTO(categoryRepository.save(category)));
    }

    @Override
    public ApiResult<Boolean> delete(Integer id) {
        try {
            categoryRepository.deleteById(id);
        } catch (Exception e) {
            throw AppException.appThrow(e.getMessage());
        }
        return ApiResult.successResponse();
    }

    @Override
    public ApiResult<CategoryResponseDTO> one(Integer id) {
        return ApiResult.successResponse(convertCategoryToCategoryResponseDTO(categoryRepository.findById(id).orElseThrow()));
    }



    private CategoryResponseDTO convertCategoryToCategoryResponseDTO(Category category) {
        return
                new CategoryResponseDTO(
                        category.getId(),
                        category.getName(),
                        category.getUrl(),
                        category.getParent() != null ?
                                convertCategoryToCategoryResponseDTO(category.getParent()) :
                                null,
                        category.getManufactures().stream().map(manufactureService::mapManufactureToManufactureDTO).collect(Collectors.toSet())
                );
    }

    public Category getParentCategoryById(Integer id) {
        if (id == null)
            return null;

        return categoryRepository.findById(id).
                orElseThrow(() -> AppException.appThrow(messageSource.getMessage(
                        "NO_SUCH_PARENT_CATEGORY",
                        null,
                        LocaleContextHolder.getLocale()
                )));
    }

    private void checkRequiredFields(CategoryRequestDTO categoryDTO) {

        if (categoryDTO == null)
            throw AppException.appThrow(messageSource.getMessage(
                    "BODY_IS_NULL",
                    null,
                    LocaleContextHolder.getLocale()
            ));

        if (categoryDTO.getName() == null)
            throw AppException.appThrow(messageSource.getMessage(
                    "NAME_IS_NULL",
                    null,
                    LocaleContextHolder.getLocale()
            ));

        if (categoryDTO.getName().isEmpty())
            throw AppException.appThrow(messageSource.getMessage(
                    "NAME_IS_EMPTY",
                    null,
                    LocaleContextHolder.getLocale()
            ));

        if (categoryDTO.getName().isBlank())
            throw AppException.appThrow(messageSource.getMessage(
                    "NAME_IS_BLANK",
                    null,
                    LocaleContextHolder.getLocale()
            ));

    }


}