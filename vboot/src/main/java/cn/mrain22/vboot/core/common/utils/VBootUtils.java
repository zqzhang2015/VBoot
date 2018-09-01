package cn.mrain22.vboot.core.common.utils;

import cn.mrain22.vboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author 22
 * VBoot系统工具类
 */
public class VBootUtils {
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 添加或注册用户时，为其密码加密
     * @param user
     * @return
     */
    public User userPasswordEncoder(User user){
        User returnUser = user;
        returnUser.setPassword(passwordEncoder.encode(user.getPassword()));
        return returnUser;
    }


}
