package com.guavapay.userms.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.guavapay.userms.enums.UserRole;
import com.guavapay.userms.util.constant.AuthConstants;

public final class JwtUtil {

    public static UserRole getRoleByAuth(String authHeader) {

        var token = authHeader.replace(AuthConstants.HEADER_STRING, "").trim();
        if (token != null) {

            var verify = JWT.require(Algorithm.HMAC512(AuthConstants.SECRET.getBytes()))
                    .build()
                    .verify(token.replace(AuthConstants.TOKEN_PREFIX, ""));

            String role = verify.getClaim("role").asString();

            return UserRole.valueOf(role);
        }

        return null;
    }
}
