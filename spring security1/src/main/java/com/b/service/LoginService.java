package com.b.service;

import com.b.pojo.User;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author zfx
 * @date 2022-07-23 10:34
 */
public interface LoginService {
    UserDetails login(User user);
    String logout();
}
