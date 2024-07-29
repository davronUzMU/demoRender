package uz.com.demorender.controller.color;

import org.springframework.web.bind.annotation.*;
import uz.com.demorender.payload.ApiResult;
import uz.com.demorender.payload.color.ColorRequestDTO;
import uz.com.demorender.payload.color.ColorResponseDTO;
import uz.com.demorender.utils.ApplicationConstants;

import java.util.List;

@RequestMapping(value = IColorController.BASE_PATH)
public interface IColorController {
    String BASE_PATH = ApplicationConstants.BASE_PATH+"/color";


    @PostMapping
    ApiResult<ColorResponseDTO> add(@RequestBody ColorRequestDTO color);

    @GetMapping
    ApiResult<List<ColorResponseDTO>> list();

    @DeleteMapping("/{id}")
    ApiResult<Boolean> delete(@PathVariable Integer id);

    @PutMapping("/{id}")
    ApiResult<ColorResponseDTO> edit(@PathVariable Integer id, @RequestBody ColorRequestDTO colorDTO);
}
