package com.devmuromi.learnspringsecurity.jwt;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.stream.Collectors;

@RestController
public class JwtAuthenticationResource {

    private JwtEncoder jwtEncoder;

    public JwtAuthenticationResource(JwtEncoder jwtEncoder) {
        this.jwtEncoder = jwtEncoder;
    }

    @PostMapping("/authenticate")
    public JwtResponse authenticate(Authentication authentication) {

        return new JwtResponse(createToken(authentication));
    }

    private String createToken(Authentication authentication) {
        var claims = JwtClaimsSet.builder()
                .issuer("self") // 발행자. 같은 앱이니 self
                .issuedAt(Instant.now())
                .expiresAt(Instant.now().plusSeconds(60 * 15)) // 15분
                .subject(authentication.getName())
                .claim("scope", createScope(authentication)) // 권한
                .build();
        JwtEncoderParameters parameters = JwtEncoderParameters.from(claims);
        return jwtEncoder.encode(parameters).getTokenValue();
    }

    private String createScope(Authentication authentication) {
        // 권한을 공백으로 구분해 취합
        return authentication.getAuthorities().stream()
                .map(a -> a.getAuthority())
                .collect(Collectors.joining(" "));
    }
}

record JwtResponse(String token) {
}
