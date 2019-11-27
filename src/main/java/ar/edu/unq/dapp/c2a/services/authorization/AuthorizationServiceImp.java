package ar.edu.unq.dapp.c2a.services.authorization;

//import com.auth0.jwt.JWT;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.auth0.jwt.interfaces.DecodedJWT;
//import com.auth0.jwt.interfaces.JWTVerifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationServiceImp implements AuthorizationService {
    @Autowired
    public AuthorizationServiceImp() {

    }

    @Override
    public boolean isAuthorized(String token, String permission) {
//        DecodedJWT decoded = JWT.decode(token);
//        JWTVerifier verifier = JWT.require(Algorithm.none()).build();
//        verifier.verify(decoded);
//        verifier.verify(token);
        return true;
    }
}
