package cn.mrain22.vboot.service;

import cn.mrain22.vboot.entity.Menu;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author mrain22
 * @since 2018-08-31
 */
public interface MenuService extends IService<Menu> {
    List<Menu> findMenuByUserId(int id);
}
