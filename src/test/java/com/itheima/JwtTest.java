package com.itheima;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {

    @Test
    public void testGen(){
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("username", "張三");
        // 生成 jwt 代碼
        String token = JWT.create()
                .withClaim("user", claims)  // 添加載荷
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 *12))    // 添加過期時間
                .sign(Algorithm.HMAC256("itheima"));    // 指定算法，配置秘鑰

        System.out.println(token);
    }

    @Test
    public void testParse() {
        // 定義字串，模擬用戶傳遞過來的 token
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9" +
                ".eyJ1c2VyIjp7ImlkIjoxLCJ1c2VybmFtZSI6IuW8teS4iSJ9LCJleHAiOjE3MDg2MzAxMTF9" +
                ".sY1CV9Kf3Bp9MlQPMu55ge_pnKCa0liZgOBtZlIyoTI";

        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("itheima")).build();

        DecodedJWT decodedJWT = jwtVerifier.verify(token); // 驗證 token, 生成一個解析後的 JWT 對象
        Map<String, Claim> claims = decodedJWT.getClaims();
        System.out.println(claims.get("user"));
    }
}
