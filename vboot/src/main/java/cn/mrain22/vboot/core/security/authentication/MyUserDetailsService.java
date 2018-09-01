package cn.mrain22.vboot.core.security.authentication;

import cn.mrain22.vboot.entity.User;
import cn.mrain22.vboot.service.UserService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author 22
 */
@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        cn.mrain22.vboot.entity.User user = userService.selectOne(new EntityWrapper<User>().eq("username",username));
        if (user == null) {
            System.out.println("该用户不存在！");
            throw new UsernameNotFoundException("该用户不存在！");
        }
        System.out.println(user);
        return new MyUserDetails(user.getName(),user.getUsername(),user.getPassword(),new ArrayList<>());
    }
}
