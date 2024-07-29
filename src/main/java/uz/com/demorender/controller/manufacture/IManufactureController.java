package uz.com.demorender.controller.manufacture;

import org.springframework.web.bind.annotation.*;
import uz.com.demorender.payload.ApiResult;
import uz.com.demorender.payload.manufacture.ManufactureRequestDTO;
import uz.com.demorender.payload.manufacture.ManufactureResponseDTO;
import uz.com.demorender.utils.ApplicationConstants;

import javax.validation.Valid;
import java.util.List;
@RequestMapping(value = IManufactureController.BATH_PATH)
public interface IManufactureController {
    String BATH_PATH = ApplicationConstants.BASE_PATH+"/manufacture";

    @PostMapping()
    ApiResult<ManufactureResponseDTO> add( @RequestBody ManufactureRequestDTO manufactureRequestDTO);

    @GetMapping
    ApiResult<List<ManufactureResponseDTO>> list();

    @GetMapping("/{id}")
    ApiResult<ManufactureResponseDTO> one(@PathVariable Integer id);

    @PostMapping("/{id}")
    ApiResult<ManufactureResponseDTO> edit(@Valid @RequestBody ManufactureRequestDTO manufactureRequestDTO,@PathVariable Integer id);

    @DeleteMapping("/{id}")
    ApiResult<Boolean> delete(@PathVariable Integer id);
}
