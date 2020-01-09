package org.feelings.auth.config;

import org.apache.commons.codec.binary.StringUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author lyq on 2019-12-31 10:54 上午
 * @desc 自定义密码加密器
 */
@Component
public class CustomPasswordEncoder implements PasswordEncoder {
    @Override
    // TODO
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return StringUtils.equals((String) charSequence, s);
    }
}
