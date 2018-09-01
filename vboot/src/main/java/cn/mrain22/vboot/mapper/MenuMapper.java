package cn.mrain22.vboot.mapper;

import cn.mrain22.vboot.entity.Menu;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 菜单表 Mapper 接口
 * </p>
 *
 * @author mrain22
 * @since 2018-08-31
 */
public interface MenuMapper extends BaseMapper<Menu> {

    List<Menu> findMenuByUserId(int id);

}
