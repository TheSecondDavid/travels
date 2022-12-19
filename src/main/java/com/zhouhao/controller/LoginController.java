package com.zhouhao.controller;

import com.zhouhao.service.LoginService;
import com.zhouhao.utils.ImageVerificationCode;
import com.zhouhao.utils.MD5;
import com.zhouhao.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@RestController
@RequestMapping("index")
public class LoginController {
    @Autowired
    LoginService loginService;

    @RequestMapping("login")
    public R login(String username, String password, String vcode, HttpSession session) throws NoSuchAlgorithmException {
        String mypassword = loginService.getPassword(username);
        if(mypassword != null && mypassword.equalsIgnoreCase(MD5.md5Encrypt(password))){
            String myvcode = (String)session.getAttribute("vcode");
            if(vcode.equalsIgnoreCase(myvcode)){
                session.setAttribute("user", username);
                return R.success();
            }
            else
                return R.err("验证码错误");
        }
        else if (mypassword == null)
            return R.err("用户名错误");
        else
            return R.err("密码错误");
    }
    @RequestMapping("verificationImage")
    public String BufferedImage(HttpSession session) throws IOException {
        BufferedImage image = ImageVerificationCode.getImage();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ImageVerificationCode.output(image, out);
        byte[] bytes = out.toByteArray();
        String vcode = ImageVerificationCode.getText();
        session.setAttribute("vcode", vcode);
        return "data:image/png;base64," + Base64.getEncoder().encodeToString(bytes);
    }
    @RequestMapping("register")
    public R register(String username, String password, String email) throws NoSuchAlgorithmException {
        if(username == null || username.isEmpty()){
            return R.err("用户名不能为空");
        }
        String myPassword = loginService.getPassword(username);
        if(myPassword != null) {
            return R.err("该用户已被注册");
        }
        if(password == null || password.isEmpty()){
            return R.err("密码不能为空");
        }
        if(email == null || email.isEmpty()){
            return R.err("邮箱不能为空");
        }
        loginService.register(username, MD5.md5Encrypt(password), email);

        return R.ok();
    }
}
