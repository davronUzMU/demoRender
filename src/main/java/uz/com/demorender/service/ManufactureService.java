package uz.com.demorender.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import uz.com.demorender.exceptions.AppException;
import uz.com.demorender.model.Category;
import uz.com.demorender.model.Manufacture;
import uz.com.demorender.payload.ApiResult;
import uz.com.demorender.payload.manufacture.ManufactureRequestDTO;
import uz.com.demorender.payload.manufacture.ManufactureResponseDTO;
import uz.com.demorender.repository.ManufactureRepository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ManufactureService implements IManufactureService {
    private final MessageSource messageSource;

    private final ManufactureRepository manufactureRepository;

    @Override
    public ApiResult<ManufactureResponseDTO> add(ManufactureRequestDTO manufactureRequestDTO) {
        checkingDataForExistenceAndNonEmpty(2, manufactureRequestDTO);
        checkManufactureAdd(manufactureRequestDTO);
        if (manufactureRepository.existsByName(manufactureRequestDTO.getName())) {
            throw AppException.appThrow(messageSource.getMessage("TOKEN_IS_NULL",
                    null,
                    LocaleContextHolder.getLocale()));
        }
        Manufacture manufacture = manufactureRepository.save(new Manufacture(manufactureRequestDTO.getName()));
        return ApiResult.
                successResponse(
                        mapManufactureToManufactureDTO(manufacture));
    }


    @Override
    public ApiResult<List<ManufactureResponseDTO>> list() {
        checkManufactureList();
        return ApiResult.successResponse(
                manufactureRepository.findAll().stream().
                        map(this::mapManufactureToManufactureDTO)
                        .collect(Collectors.toList()));
    }


    @Override
    public ApiResult<ManufactureResponseDTO> one(Integer id) {
        checkingDataForExistence(id, manufactureRepository.existsById(id));
        return ApiResult.successResponse(
                mapManufactureToManufactureDTO(
                        manufactureRepository.findById(id).orElseThrow(() -> AppException.appThrow(messageSource.getMessage("", null,
                                LocaleContextHolder.getLocale())))
                ));
    }


    @Override
    public ApiResult<ManufactureResponseDTO> edit(ManufactureRequestDTO manufactureRequestDTO, Integer id) {
        checkingDataForExistenceAndNonEmpty(id, manufactureRequestDTO);
        Manufacture manufacture = checkingDataForExistenceManufacture(id);
        editManufactures(manufactureRequestDTO, id, manufacture);
        return ApiResult.
                successResponse(
                        mapManufactureToManufactureDTO(manufacture));
    }



    @Override
    public ApiResult<Boolean> delete(Integer id) {
        checkManufactureById(id);
        manufactureRepository.deleteById(id);
        return ApiResult.successResponse(true);
    }


    @Override
    public ManufactureResponseDTO mapManufactureToManufactureDTO(Manufacture manufacture) {
        return
                new
                        ManufactureResponseDTO(manufacture.getId(),
                        manufacture.getName(),
                        Objects.isNull(manufacture.getCategorySet()) ? "" :
                                manufacture.getCategorySet()
                                        .stream()
                                        .map(Category::getName)
                                        .collect(Collectors.joining(", "))
                );
    }

    private void checkManufactureAdd(ManufactureRequestDTO manufactureRequestDTO) {
        if (Objects.isNull(manufactureRequestDTO.getName())) {
            throw AppException.appThrow(messageSource.getMessage("",
                    null,
                    LocaleContextHolder.getLocale()));
        }
        if (manufactureRequestDTO.getName().isEmpty()) {
            throw AppException.appThrow(messageSource.getMessage("",
                    null,
                    LocaleContextHolder.getLocale()));
        }
        if (manufactureRequestDTO.getName().isBlank()) {
            throw AppException.appThrow(messageSource.getMessage("",
                    null,
                    LocaleContextHolder.getLocale()));
        }
    }

    private void checkingDataForExistenceAndNonEmpty(Integer id, Object object) {
        if (Objects.isNull(id)) {
            throw AppException.appThrow(messageSource.getMessage("",
                    null,
                    LocaleContextHolder.getLocale()));
        }
        if (Objects.isNull(object)) {
            throw AppException.appThrow(messageSource.getMessage("",
                    null,
                    LocaleContextHolder.getLocale()));
        }
    }

    private void checkManufactureList() {
        if (manufactureRepository.findAll().isEmpty())
            throw AppException.appThrow(messageSource.getMessage("",
                    null,
                    LocaleContextHolder.getLocale()));
    }

    private void checkingDataForExistence(Integer id, boolean existsById) {
        if (Objects.isNull(id))
            throw AppException.appThrow(messageSource.getMessage("",
                    null,
                    LocaleContextHolder.getLocale()));
        if (Objects.equals(existsById, false))
            throw AppException.appThrow(messageSource.getMessage("", null,
                    LocaleContextHolder.getLocale()));
    }

    private Manufacture checkingDataForExistenceManufacture(Integer id) {
        return manufactureRepository.
                findById(id).
                    orElseThrow(()->AppException.appThrow(messageSource.getMessage("",
                            null,
                            LocaleContextHolder.getLocale())));
    }
    private void editManufactures(ManufactureRequestDTO manufactureRequestDTO, Integer id, Manufacture manufacture) {
        manufacture.setName(manufactureRequestDTO.getName());
        manufactureRepository.save(manufacture);
        manufactureRequestDTO.setId(id);
    }
    private void checkManufactureById(Integer id) {
        if(!manufactureRepository.existsById(id))
            throw AppException.appThrow(messageSource.getMessage("",
                    null,
                    LocaleContextHolder.getLocale()));
    }
}
