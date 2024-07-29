package uz.com.demorender.service;

import org.springframework.stereotype.Service;
import uz.com.demorender.payload.ApiResult;
import uz.com.demorender.payload.role.RoleRequestDTO;
import uz.com.demorender.payload.role.RoleResponseDTO;

import java.util.List;

@Service
public class RoleService implements IRoleService{
    @Override
    public ApiResult<RoleResponseDTO> add(RoleRequestDTO roleRequestDTO) {
        return null;
    }

    @Override
    public ApiResult<List<RoleResponseDTO>> list() {
        return null;
    }

    @Override
    public ApiResult<RoleResponseDTO> one(Integer id) {
        return null;
    }

    @Override
    public ApiResult<RoleResponseDTO> edit(RoleRequestDTO roleRequestDTO, Integer id) {
        return null;
    }

    @Override
    public ApiResult<Boolean> delete(Integer id) {
        return null;
    }
}
