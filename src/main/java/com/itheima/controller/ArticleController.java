package com.itheima.controller;

import com.itheima.pojo.Result;
import com.itheima.utils.JwtUtiil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @GetMapping("/list")
    public Result<String> list(/*@RequestHeader(name = "Authorization") String token, HttpServletResponse response*/) {
        return Result.success("所有的文章數據");

//        // 驗證 token
//        try {
//            Map<String, Object> claims = JwtUtiil.parseToken(token);
//            return Result.success("所有的文章數據");
//        } catch (Exception e) {
//            // http 響應狀態為 401
//            response.setStatus(401);
//            return Result.error("未登入");
//        }

    }
}
