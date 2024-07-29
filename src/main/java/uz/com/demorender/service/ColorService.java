package uz.com.demorender.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import uz.com.demorender.exceptions.AppException;
import uz.com.demorender.model.Color;
import uz.com.demorender.payload.ApiResult;
import uz.com.demorender.payload.color.ColorRequestDTO;
import uz.com.demorender.payload.color.ColorResponseDTO;
import uz.com.demorender.repository.ColorRepository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ColorService implements IColorService{

    private final ColorRepository colorRepository;

    private final MessageSource messageSource;

    @Override
    public ApiResult<ColorResponseDTO> add(ColorRequestDTO color) {
        checkingDataForExistenceAndNonEmpty(2, color);
        checkColorDTO(color);

        Color save = colorRepository.save(new Color(color.getColor()));
        return ApiResult.successResponse(
                new ColorResponseDTO(save.getId(),save.getColor()));
    }



    @Override
    public ApiResult<List<ColorResponseDTO>> List() {
        checkColorList();
        return ApiResult.successResponse(colorRepository.findAll()
                .stream()
                .map(this::convertColorToColorResponseDTO)
                .collect(Collectors.toList()));
    }


    @Override
    public ApiResult<Boolean> deleteColor(Integer id) {
        checkingDataForExistenceAndNonEmpty(id, colorRepository.findById(id));
        colorRepository.deleteById(id);
        return ApiResult.successResponse(true);
    }

    @Override
    public ApiResult<ColorResponseDTO> edit(Integer id, ColorRequestDTO colorDTO) {
        checkingDataForExistenceAndNonEmpty(id, colorDTO);
        checkColorDTO(colorDTO);
        Color color = colorRepository.findById(id).orElseThrow();
        color.setColor(colorDTO.getColor());
        Color color1 = colorRepository.save(color);
        return ApiResult.successResponse(convertColorToColorResponseDTO(color1));
    }


    private void checkingDataForExistenceAndNonEmpty(Integer id,Object object) {
        if (id == null || id <= 0)
            throw AppException.appThrow(messageSource.getMessage(
                    "WRONG_ID",
                    null,
                    LocaleContextHolder.getLocale()
            ));
        if (Objects.isNull(object))
            throw AppException.appThrow(messageSource.getMessage(
                    "MANUFACTURE_IS_NULL",
                    null,
                    LocaleContextHolder.getLocale()));
    }
    private void checkColorList() {
        List<Color> all = colorRepository.findAll();
        if (all.isEmpty())
            throw AppException.appThrow(
                    messageSource.getMessage("COLOR_LIST_NOT_AVAILABLE",
                            null,
                            LocaleContextHolder.getLocale()));
    }
    private ColorResponseDTO convertColorToColorResponseDTO(Color color) {
        return
                new ColorResponseDTO(
                        color.getId(),
                        color.getColor()
                );
    }
    private void checkColorDTO(ColorRequestDTO colorDTO) {
        if (colorDTO.getColor() == null)
            throw AppException.appThrow(messageSource.getMessage(
                    "COLORING_IS_MANDATORY",
                    null,
                    LocaleContextHolder.getLocale()
            ));

        if (colorDTO.getColor().isEmpty())
            throw AppException.appThrow(messageSource.getMessage(
                    "COLORING_IS_MANDATORY",
                    null,
                    LocaleContextHolder.getLocale()
            ));

        if (colorDTO.getColor().isBlank())
            throw AppException.appThrow(messageSource.getMessage(
                    "COLORING_IS_MANDATORY",
                    null,
                    LocaleContextHolder.getLocale()
            ));
    }
}
