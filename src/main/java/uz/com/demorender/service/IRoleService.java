package uz.com.demorender.service;

import uz.com.demorender.payload.ApiResult;
import uz.com.demorender.payload.role.RoleRequestDTO;
import uz.com.demorender.payload.role.RoleResponseDTO;

import java.util.List;

public interface IRoleService {
    ApiResult<RoleResponseDTO> add(RoleRequestDTO roleRequestDTO);

    ApiResult<List<RoleResponseDTO>> list();

    ApiResult<RoleResponseDTO> one(Integer id);

    ApiResult<RoleResponseDTO> edit(RoleRequestDTO roleRequestDTO, Integer id);

    ApiResult<Boolean> delete(Integer id);
}
