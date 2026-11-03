package SS10.Controller;

import SS10.Model.dto.LoginRequest;
import SS10.Security.JwtProvider;
import SS10.Security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        // Bước 1: Xác thực username và password
        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                request.getUsername(),
                                request.getPassword()
                        )
                );

        // Bước 2: Lấy thông tin UserPrincipal
        UserPrincipal userPrincipal =
                (UserPrincipal) authentication.getPrincipal();

        // Bước 3: Tạo JWT
        String token = jwtProvider.generateToken(userPrincipal);

        // Bước 4: Trả kết quả về client
        return ResponseEntity.ok(
                Map.of(
                        "accessToken", token,
                        "type", "Bearer",
                        "username", userPrincipal.getUsername()
                )
        );
    }
}
