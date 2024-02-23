package com.itheima.pojo;

import lombok.Data;

import java.time.LocalDateTime;
// lombok 在編譯階段， 為實體類自動生成 setter getter toString
// pom 文件中引入依賴，在實體類上添加註解
@Data
public class User {
    private Integer id ;
    private String username;
    private String password;
    private String nickname;
    private String email;
    private String userPic; // 使用者頭像地址
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
