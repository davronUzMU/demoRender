package uz.com.demorender.controller.manufacture;

import org.springframework.web.bind.annotation.RestController;
import uz.com.demorender.payload.ApiResult;
import uz.com.demorender.payload.manufacture.ManufactureRequestDTO;
import uz.com.demorender.payload.manufacture.ManufactureResponseDTO;
import uz.com.demorender.service.IManufactureService;

import java.util.List;
@RestController
public class ManufactureController implements IManufactureController{

    private final IManufactureService iManufactureService;

    public ManufactureController(IManufactureService iManufactureService) {
        this.iManufactureService = iManufactureService;
    }

    @Override
    public ApiResult<ManufactureResponseDTO> add(ManufactureRequestDTO manufactureRequestDTO) {
        return iManufactureService.add(manufactureRequestDTO);
    }

    @Override
    public ApiResult<List<ManufactureResponseDTO>> list() {
        return iManufactureService.list();
    }

    @Override
    public ApiResult<ManufactureResponseDTO> one(Integer id) {
        return iManufactureService.one(id);
    }

    @Override
    public ApiResult<ManufactureResponseDTO> edit(ManufactureRequestDTO manufactureRequestDTO, Integer id) {
        return iManufactureService.edit(manufactureRequestDTO,id);
    }

    @Override
    public ApiResult<Boolean> delete(Integer id) {
        return iManufactureService.delete(id);
    }
}
