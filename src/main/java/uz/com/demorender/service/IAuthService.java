package uz.com.demorender.service;

import uz.com.demorender.payload.ApiResult;
import uz.com.demorender.payload.AuthRequestDTO;
import uz.com.demorender.payload.TokenDTO;
import uz.com.demorender.payload.UserDTO;

public interface IAuthService {
    ApiResult<TokenDTO> register(UserDTO userDTO);

    ApiResult<TokenDTO> register(AuthRequestDTO authRequestDTO);
}
