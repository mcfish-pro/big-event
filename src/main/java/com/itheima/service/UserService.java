package com.itheima.service;

import com.itheima.pojo.User;

public interface UserService {
    // 根據用戶名查詢用戶
    User findByUserName(String username);

    void register(String username, String password);
}
