package Group3.ShopAcc.Service;

import Group3.ShopAcc.Dto.JwtAuthenticationResponse;
import Group3.ShopAcc.Dto.RefreshTokenRequest;
import Group3.ShopAcc.Dto.SignUpRequest;
import Group3.ShopAcc.Dto.SigninRequest;
import Group3.ShopAcc.Entity.Account;
import Group3.ShopAcc.Entity.Role;
import Group3.ShopAcc.Repository.AccountRepository;
import Group3.ShopAcc.Repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService{
    private final AccountRepository accountRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;
    public Account signup(SignUpRequest signUpRequest){

        Account account = new Account();
        account.setUserName(signUpRequest.getUsername());
        account.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        account.setRoleID(signUpRequest.getRoleName());

        return accountRepository.save(account);
    }

    public JwtAuthenticationResponse signin(SigninRequest signinRequest){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signinRequest.getUsername(),
                signinRequest.getPassword()));
        var account = accountRepository.findByUserName(signinRequest.getUsername()).orElseThrow(()->new IllegalArgumentException("Invalid username or password"));
        var jwt = jwtService.generateToken(account);
        var refreshToken = jwtService.generateRefreshToken(new HashMap<>(),account);

        JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();
        jwtAuthenticationResponse.setToken(jwt);
        jwtAuthenticationResponse.setRefreshToken(refreshToken);
        return jwtAuthenticationResponse;
    }
    public JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest){
        String username = jwtService.extractUserName(refreshTokenRequest.getToken());
        Account account = accountRepository.findByUserName(username).orElseThrow();
        if(jwtService.isTokenValid(refreshTokenRequest.getToken(), account)){
            var jwt = jwtService.generateToken(account);
            JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();
            jwtAuthenticationResponse.setToken(jwt);
            jwtAuthenticationResponse.setRefreshToken(refreshTokenRequest.getToken());
            return jwtAuthenticationResponse;
        }
        return null;
    }
}
