package uz.com.demorender.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.com.demorender.exceptions.AppException;
import uz.com.demorender.model.User;
import uz.com.demorender.model.enams.EnumType;
import uz.com.demorender.payload.ApiResult;
import uz.com.demorender.payload.AuthRequestDTO;
import uz.com.demorender.payload.TokenDTO;
import uz.com.demorender.payload.UserDTO;
import uz.com.demorender.repository.UserRepository;
import uz.com.demorender.security.JwtService;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AuthService implements IAuthService{

    private final UserRepository userRepository;

    private final JwtService jwtService;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    @Override
    public ApiResult<TokenDTO> register(UserDTO userDTO) {
        if(Objects.isNull(userDTO)){
            throw AppException.appThrow("wrong information ");
        }
        User.UserBuilder userBuilder = User.builder();
        userBuilder.firstName(userDTO.getFirstName());
        userBuilder.lastName(userDTO.getLastName());
        userBuilder.phoneNumber(userDTO.getPhoneNumber());
        userBuilder.email(userDTO.getEmail());
        userBuilder.password(passwordEncoder.encode(userDTO.getPassword()));
        userBuilder.type(EnumType.USER);
        userRepository.save(userBuilder.build());
        var jwtToken = jwtService.generateToken(userBuilder.build());
        return ApiResult.successResponse(
                TokenDTO.builder().token(jwtToken)
                        .build());
    }

    @Override
    public ApiResult<TokenDTO> register(AuthRequestDTO authRequestDTO) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequestDTO.getEmail(),
                        authRequestDTO.getPassword()
                )
        );
        User user = userRepository.findByEmail(authRequestDTO.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return ApiResult.successResponse(
                TokenDTO.builder().token(jwtToken)
                        .build());
    }
}
