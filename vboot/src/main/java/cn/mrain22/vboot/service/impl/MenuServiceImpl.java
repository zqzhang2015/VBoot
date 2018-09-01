package cn.mrain22.vboot.service.impl;

import cn.mrain22.vboot.entity.Menu;
import cn.mrain22.vboot.mapper.MenuMapper;
import cn.mrain22.vboot.service.MenuService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author mrain22
 * @since 2018-08-31
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    @Resource
    MenuMapper menuMapper;

    @Override
    public List<Menu> findMenuByUserId(int id) {
        return menuMapper.findMenuByUserId(id);
    }
}
