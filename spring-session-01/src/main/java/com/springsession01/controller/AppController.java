package com.springsession01.controller;

import com.springsession01.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author zhangfx
 * @date 2022/8/9
 */
// 服务器1设置session
@RestController
@RequestMapping("/app1")
public class AppController {
    @RequestMapping("/set")
    public String set(HttpSession session){
        User user = new User("1001","zfx","24","1");
        session.setAttribute("user", user);
        return String.valueOf(session.getId());
    }
    @RequestMapping("/get")
    public Object get(HttpSession session) {
        return session.getId();
    }
}
