package com.roje.manager.service.impl;

import com.roje.manager.dao.SysUserDao;
import com.roje.manager.data.SecurityUserDetails;
import com.roje.manager.data.SysUser;
import com.roje.manager.common.exception.EmptyUserNameException;
import com.roje.manager.service.SysUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author Ro
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    private final SysUserDao userDao;

    public SysUserServiceImpl(SysUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (StringUtils.isEmpty(username)) {
            throw new EmptyUserNameException("用户名不能为空");
        }
        SysUser user = userDao.getByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        return new SecurityUserDetails(user, new ArrayList<>());
    }
}
