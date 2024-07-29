package uz.com.demorender.controller.color;

import org.springframework.web.bind.annotation.RestController;
import uz.com.demorender.payload.ApiResult;
import uz.com.demorender.payload.color.ColorRequestDTO;
import uz.com.demorender.payload.color.ColorResponseDTO;
import uz.com.demorender.service.IColorService;

import java.util.List;
@RestController
public class ColorController implements IColorController{
    private final IColorService colorService;

    public ColorController(IColorService colorService) {
        this.colorService = colorService;
    }


    @Override
    public ApiResult<ColorResponseDTO> add(ColorRequestDTO color) {
        return colorService.add(color);
    }

    @Override
    public ApiResult<List<ColorResponseDTO>> list() {
        return colorService.List();
    }
    @Override
    public ApiResult<Boolean> delete(Integer id) {
        return colorService.deleteColor(id);
    }

    @Override
    public ApiResult<ColorResponseDTO> edit(Integer id, ColorRequestDTO colorDTO) {
        return colorService.edit(id,colorDTO);
    }
}
