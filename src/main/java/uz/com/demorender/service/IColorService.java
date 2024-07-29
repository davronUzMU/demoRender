package uz.com.demorender.service;

import uz.com.demorender.payload.ApiResult;
import uz.com.demorender.payload.color.ColorRequestDTO;
import uz.com.demorender.payload.color.ColorResponseDTO;

import java.util.List;

public interface IColorService {

    ApiResult<ColorResponseDTO> add(ColorRequestDTO color);

    ApiResult<List<ColorResponseDTO>> List();

    ApiResult<Boolean> deleteColor(Integer id);

    ApiResult<ColorResponseDTO> edit(Integer id, ColorRequestDTO colorDTO);
}
