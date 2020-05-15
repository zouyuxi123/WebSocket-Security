package com.demo.securitywebsocket.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.securitywebsocket.bean.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: 邹玉玺
 * @date: 2020/5/13-10:15
 */
@Mapper
public interface UserRepository extends BaseMapper<User> {
}
