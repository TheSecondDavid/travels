package com.zhouhao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@TableName("t_user")
public class User {
    String username;
    String password;
    String email;
}
