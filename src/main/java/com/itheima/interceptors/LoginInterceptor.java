package com.itheima.interceptors;

import com.itheima.pojo.Result;
import com.itheima.utils.JwtUtiil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 令牌驗證
        String token = request.getHeader("Authorization");
        // 驗證 token
        try {
            Map<String, Object> claims = JwtUtiil.parseToken(token);
            return true;    // 通過
        } catch (Exception e) {
            // http 響應狀態 401
            response.setStatus(401);
            return false;   // 未通過
        }
    }
}
