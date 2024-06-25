//package br.com.projeto.ecommerce.securityJwt;
//
//import br.com.projeto.ecommerce.vo.v1.security.TokenVO;
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.JWTVerifier;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.auth0.jwt.interfaces.DecodedJWT;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.stereotype.Service;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//
//import javax.annotation.PostConstruct;
//import javax.servlet.http.HttpServletRequest;
//import java.util.Base64;
//import java.util.Date;
//import java.util.List;
//
//@Service
//public class JwtTokenProvider {
//
//    @Value("${security.jwt.token.secret-key:secret}")
//    private String secretKey = "secret";
//
//    @Value("${security.jwt.token.expire-lenght:3600000}")
//    private long validityInMiliSeconds = 3600000;
//
//    @Autowired
//    private UserDetailsService detailsService;
//
//    Algorithm algorithm = null;
//
//    @PostConstruct
//    protected void init() {
//        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
//        algorithm = Algorithm.HMAC256(secretKey.getBytes());
//    }
//
//    public TokenVO createAccessToken(String username, List<String> roles) {
//        Date now = new Date();
//        Date validity = new Date(now.getTime() + validityInMiliSeconds);
//        String accessToken = getRefreshToken(username, roles, now, validity);
//        String refreshToken = getRefreshToken(username, roles, now);
//
//        return new TokenVO(username, true, now, validity, accessToken, refreshToken);
//    }
//
//    private String getRefreshToken(String username, List<String> roles, Date now, Date validity) {
//        String issuerUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
//        return JWT.create()
//                .withClaim("roles", roles)
//                .withIssuedAt(now)
//                .withExpiresAt(validity)
//                .withSubject(username)
//                .withIssuer(issuerUrl)
//                .sign(algorithm)
//                .strip();
//    }
//
//    private String getRefreshToken(String username, List<String> roles, Date now) {
//        Date validityRefreshToken = new Date(now.getTime() + (validityInMiliSeconds * 3));
//        return JWT.create()
//                .withClaim("roles", roles)
//                .withIssuedAt(now)
//                .withExpiresAt(validityRefreshToken)
//                .withSubject(username)
//                .sign(algorithm)
//                .strip();
//    }
//
//    public Authentication getAuthentication(String token) {
//        DecodedJWT decodedJWT = decodedToken(token);
//        UserDetails userDetails = this.detailsService.loadUserByUsername(decodedJWT.getSubject());
//        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
//    }
//
//    private DecodedJWT decodedToken(String token) {
//        Algorithm alg = Algorithm.HMAC256(secretKey.getBytes());
//        JWTVerifier verifier = JWT.require(alg).build();
//        DecodedJWT decodedJWT = verifier.verify(token);
//        return decodedJWT;
//    }
//
//    public String resolveToken(HttpServletRequest request) {
//
//        return null;
//    }
//
//}
