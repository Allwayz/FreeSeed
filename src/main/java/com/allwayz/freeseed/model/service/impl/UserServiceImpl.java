package com.allwayz.freeseed.model.service.impl;

import com.allwayz.freeseed.model.entity.User;
import com.allwayz.freeseed.model.mapper.UserMapper;
import com.allwayz.freeseed.model.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Allwayz
 * @since 2020-02-05
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
