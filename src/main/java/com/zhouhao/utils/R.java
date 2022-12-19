package com.zhouhao.utils;

import lombok.Data;

@Data
public class R {
    String msg;
    Integer code;

    public R(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }
    public static R ok(){
        return new R(0, null);
    }
    public static R err(String msg){
        return new R(-1, msg);
    }
    public static R success(){
        return R.success(null);
    }
    public static R success(String msg){
        return new R(0, msg);
    }
}
