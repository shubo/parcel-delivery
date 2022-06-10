package com.guavapay.orderms.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.guavapay.orderms.enums.UserRole;
import com.guavapay.orderms.util.constant.AuthConstants;

public final class JwtUtil {

    private static DecodedJWT getDecodedJwt(String token) {

        return JWT.require(Algorithm.HMAC512(AuthConstants.SECRET.getBytes()))
                .build()
                .verify(token.replace(AuthConstants.TOKEN_PREFIX, ""));
    }

    public static UserRole getRoleByAuth(String authHeader) {

        var token = authHeader.replace(AuthConstants.HEADER_STRING, "").trim();
        if (token != null) {

            var verify = getDecodedJwt(token);

            String role = verify.getClaim("role").asString();

            return UserRole.valueOf(role);
        }

        return null;
    }

    public static String getUserName(String authHeader) {
        var token = authHeader.replace(AuthConstants.HEADER_STRING, "").trim();
        if (token != null) {

            var verify = getDecodedJwt(token);

            return verify.getSubject();
        }

        return null;
    }
}
