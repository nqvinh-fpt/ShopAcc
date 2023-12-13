package Group3.ShopAcc.Controller;

import Group3.ShopAcc.Dto.JwtAuthenticationResponse;
import Group3.ShopAcc.Dto.RefreshTokenRequest;
import Group3.ShopAcc.Dto.SignUpRequest;
import Group3.ShopAcc.Dto.SigninRequest;
import Group3.ShopAcc.Entity.Account;
import Group3.ShopAcc.Entity.Role;
import Group3.ShopAcc.Service.AuthenticationService;
import Group3.ShopAcc.Dto.JwtAuthenticationResponse;
import Group3.ShopAcc.Dto.RefreshTokenRequest;
import Group3.ShopAcc.Dto.SignUpRequest;
import Group3.ShopAcc.Dto.SigninRequest;
import Group3.ShopAcc.Entity.Account;
import Group3.ShopAcc.Service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    @PostMapping("/signup")
    public ResponseEntity<Account> signup(@RequestBody SignUpRequest signUpRequest){
        return ResponseEntity.ok(authenticationService.signup(signUpRequest));
    }
    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SigninRequest signinRequest){
        return ResponseEntity.ok(authenticationService.signin(signinRequest));
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtAuthenticationResponse> refresh(@RequestBody RefreshTokenRequest refreshTokenRequest){
        return ResponseEntity.ok(authenticationService.refreshToken(refreshTokenRequest));
    }
}
