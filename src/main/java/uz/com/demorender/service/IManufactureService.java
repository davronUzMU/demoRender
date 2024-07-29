package uz.com.demorender.service;

import uz.com.demorender.model.Manufacture;
import uz.com.demorender.payload.ApiResult;
import uz.com.demorender.payload.manufacture.ManufactureRequestDTO;
import uz.com.demorender.payload.manufacture.ManufactureResponseDTO;

import java.util.List;

public interface IManufactureService {
    ApiResult<ManufactureResponseDTO> add(ManufactureRequestDTO manufactureRequestDTO);

    ApiResult<List<ManufactureResponseDTO>> list();

    ApiResult<ManufactureResponseDTO> one(Integer id);


    ApiResult<ManufactureResponseDTO> edit(ManufactureRequestDTO manufactureRequestDTO, Integer id);

    ApiResult<Boolean> delete(Integer id);

    ManufactureResponseDTO mapManufactureToManufactureDTO(Manufacture manufacture);
}
