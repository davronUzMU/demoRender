package uz.com.demorender.controller.role;

import org.springframework.web.bind.annotation.RestController;
import uz.com.demorender.payload.ApiResult;
import uz.com.demorender.payload.role.RoleRequestDTO;
import uz.com.demorender.payload.role.RoleResponseDTO;
import uz.com.demorender.service.IRoleService;

import java.util.List;
@RestController
public class RoleController implements IRoleController{

    private final IRoleService iRoleService;

    public RoleController(IRoleService iRoleService) {
        this.iRoleService = iRoleService;
    }

    @Override
    public ApiResult<RoleResponseDTO> add(RoleRequestDTO roleRequestDTO) {
        return iRoleService.add(roleRequestDTO);
    }

    @Override
    public ApiResult<List<RoleResponseDTO>> list() {
        return iRoleService.list();
    }

    @Override
    public ApiResult<RoleResponseDTO> one(Integer id) {
        return iRoleService.one(id);
    }

    @Override
    public ApiResult<RoleResponseDTO> edit(RoleRequestDTO roleRequestDTO, Integer id) {
        return iRoleService.edit(roleRequestDTO,id);
    }

    @Override
    public ApiResult<Boolean> delete(Integer id) {
        return iRoleService.delete(id);
    }
}
