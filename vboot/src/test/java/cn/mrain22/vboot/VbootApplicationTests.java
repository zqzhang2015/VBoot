package cn.mrain22.vboot;

import cn.mrain22.vboot.entity.Menu;
import cn.mrain22.vboot.service.MenuService;
import cn.mrain22.vboot.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VbootApplicationTests {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MenuService menuService;



    @Test
    public void contextLoads() {
//        User user = new User();
//        user.setName("VB_管理员");
//        user.setUsername("admin");
//        user.setPassword(passwordEncoder.encode("123456"));
//        user.setAddress("青岛滨海学院");
//        boolean insert = userService.insert(user);
//        System.out.println("------------------------->"+insert);
        List<Menu> menuByUserId = menuService.findMenuByUserId(1);
        System.out.println("------------------------->"+menuByUserId);



    }

}
