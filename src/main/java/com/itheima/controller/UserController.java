package com.itheima.controller;

import com.itheima.pojo.Result;
import com.itheima.pojo.User;
import com.itheima.service.UserService;
import com.itheima.utils.JwtUtiil;
import com.itheima.utils.Md5Util;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$")String password) {
            User u = userService.findByUserName(username);
            if (u == null) {
                // 沒有佔用
                // 註冊
                userService.register(username, password);
                return Result.success();

            } else {
                // 佔用
                return Result.error("用戶名已被佔用");
            }
    }
    @PostMapping("/login")
    public Result<String> login(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$")String password) {
        // 根據用戶名查詢用戶
        User loginUser = userService.findByUserName(username);

        // 判斷該用戶是否存在
        if (loginUser == null) {
            return Result.error("用戶名錯誤");
        }
        // 判斷密碼是否存在 loginUser 對象中的 password 是加密後
        if (Md5Util.getMD5String(password).equals(loginUser.getPassword())) {
            // 登錄成功
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", loginUser.getId());
            claims.put("username", loginUser.getUsername());
            String token = JwtUtiil.genToken(claims);
            return Result.success(token);
        }
        return Result.error("密碼錯誤");
    }
}
