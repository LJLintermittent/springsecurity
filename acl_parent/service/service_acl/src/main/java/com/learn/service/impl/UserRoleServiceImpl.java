package com.learn.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.entity.UserRole;
import com.learn.mapper.UserRoleMapper;
import com.learn.service.UserRoleService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author testjava
 * @since 2020-01-12
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

}
