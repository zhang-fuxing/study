package com.b.service.impl;

import com.b.dao.UserDao;
import com.b.pojo.User;
import com.b.pojo.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zfx
 * @date 2022-07-23 9:34
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //查询用户
        User user = userDao.getUserByUserName(username);
        // TODO 权限封装,也可以直接使用字符串切割在UserDetails实现类中封装好权限信息
        List<String> auths = new ArrayList<>(List.of(user.getLevel()));
        return new UserDetailsImpl(user,auths);
    }
}
