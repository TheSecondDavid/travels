package com.zhouhao.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
    public static String md5Encrypt(String string) throws NoSuchAlgorithmException {
        byte[] bytes = string.getBytes(StandardCharsets.UTF_8);
        MessageDigest digest = MessageDigest.getInstance("md5");
        byte[] result = digest.digest(bytes);
        //对于加密后的结果进行输出：将字节数组转为16进制的字符串
        StringBuffer sb = new StringBuffer();
        for (byte b : result) {
            int num = b & 0xff;//加盐，转类型的时候保证补码相同
            String str = Integer.toHexString(num);
            if(str.length() == 1){
                sb.append("0");
            }
            sb.append(str);
        }
        return sb.toString();
    }
    public static void main(String[] args) throws NoSuchAlgorithmException {
        if("".isEmpty())
            System.out.println(MD5.md5Encrypt("123456"));
    }
}
