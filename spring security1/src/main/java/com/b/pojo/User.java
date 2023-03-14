package com.b.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author zfx
 * @date 2022-07-23 10:29
 */
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String username;
    private String password;
    private String level;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
