package uz.com.demorender.controller.role;

import org.springframework.web.bind.annotation.*;
import uz.com.demorender.payload.ApiResult;
import uz.com.demorender.payload.role.RoleRequestDTO;
import uz.com.demorender.payload.role.RoleResponseDTO;
import uz.com.demorender.utils.ApplicationConstants;

import javax.validation.Valid;
import java.util.List;
@RequestMapping(value = IRoleController.BATH_PATH)
public interface IRoleController {
    String BATH_PATH = ApplicationConstants.BASE_PATH+"/role";

    @PostMapping
    ApiResult<RoleResponseDTO> add(@Valid @RequestBody RoleRequestDTO roleRequestDTO);

    @GetMapping
    ApiResult<List<RoleResponseDTO>> list();

    @GetMapping("/{id}")
    ApiResult<RoleResponseDTO> one(@PathVariable Integer id);

    @PostMapping("/{id}")
    ApiResult<RoleResponseDTO> edit(@Valid @RequestBody RoleRequestDTO roleRequestDTO,@PathVariable Integer id);

    @DeleteMapping("/{id}")
    ApiResult<Boolean> delete(@PathVariable Integer id);
}
