package cn.mrain22.vboot.controller;

import cn.mrain22.vboot.entity.Menu;
import cn.mrain22.vboot.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/system")
public class SystemController {
    @Autowired
    private MenuService menuService;

    @GetMapping("/menu")
    public List<Menu> menuNode(){
        System.out.println("我被请求了！");
        return menuService.findMenuByUserId(1);
    }
}
