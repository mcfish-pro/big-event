package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 統一響應結果
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Result<T> {
    private Integer code;   // 業務狀態碼 0-成功 1-失
    private String message; // 提示訊息
    private T data; // 響應數據

    // 快速返回操作原功響應結果（帶響應數據）
    public static <E> Result<E> success(E data) {
        return new Result<>(0, "操作成功", data);
    }

    // 快速返回操作成功響應結果
    public static Result success() {
        return new Result(0, "操作成功", null);
    }
    public static Result error(String message) {
        return new Result(1, message, null);
    }
}
