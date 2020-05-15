package com.demo.securitywebsocket.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.securitywebsocket.bean.Role;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: 邹玉玺
 * @date: 2020/5/13-10:16
 */
@Mapper
public interface RoleRepository extends BaseMapper<Role> {
}
