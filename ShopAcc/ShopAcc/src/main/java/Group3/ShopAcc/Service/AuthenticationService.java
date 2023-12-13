package Group3.ShopAcc.Service;

import Group3.ShopAcc.Dto.JwtAuthenticationResponse;
import Group3.ShopAcc.Dto.RefreshTokenRequest;
import Group3.ShopAcc.Dto.SignUpRequest;
import Group3.ShopAcc.Dto.SigninRequest;
import Group3.ShopAcc.Entity.Account;
import Group3.ShopAcc.Entity.Role;

public interface AuthenticationService {
    Account signup(SignUpRequest signUpRequest);
    JwtAuthenticationResponse signin(SigninRequest signinRequest);
    JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
