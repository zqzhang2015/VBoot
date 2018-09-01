package cn.mrain22.vboot.service.impl;

import cn.mrain22.vboot.entity.Role;
import cn.mrain22.vboot.mapper.RoleMapper;
import cn.mrain22.vboot.service.RoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author mrain22
 * @since 2018-08-31
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
