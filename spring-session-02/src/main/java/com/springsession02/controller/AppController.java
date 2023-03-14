package com.springsession02.controller;

import com.springsession02.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author zhangfx
 * @date 2022/8/9
 */
// 服务器2设置session
@RestController
@RequestMapping("/app2")
public class AppController {
    @RequestMapping("/set")
    public String set(HttpSession session) {
        User user = new User("1002", "kfk", "24", "0");
        session.setAttribute("user", user);
        session.setAttribute("datasource", "0");
        return String.valueOf(session.getId());
    }
    @RequestMapping("/get")
    public Object get(HttpSession session) {
        return session.getId();
    }
}
