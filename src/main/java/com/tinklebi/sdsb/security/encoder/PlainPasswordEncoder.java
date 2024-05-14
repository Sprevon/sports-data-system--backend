package com.tinklebi.sdsb.security.encoder;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/5/14 17:41
 */
public class PlainPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
        return rawPassword.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return rawPassword.toString().equals(encodedPassword);
    }
}
