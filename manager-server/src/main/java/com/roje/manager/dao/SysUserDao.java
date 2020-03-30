package com.roje.manager.dao;

import com.roje.manager.data.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ro
 */
@Repository
public interface SysUserDao extends JpaRepository<SysUser, Long> {
    SysUser getByUsername(String name);
}
