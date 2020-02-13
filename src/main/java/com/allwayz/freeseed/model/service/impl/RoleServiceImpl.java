package com.allwayz.freeseed.model.service.impl;

import com.allwayz.freeseed.model.entity.Role;
import com.allwayz.freeseed.model.mapper.RoleMapper;
import com.allwayz.freeseed.model.service.IRoleService;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {
}
