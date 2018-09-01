package cn.mrain22.vboot.service.impl;

import cn.mrain22.vboot.entity.User;
import cn.mrain22.vboot.mapper.UserMapper;
import cn.mrain22.vboot.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author mrain22
 * @since 2018-08-30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
