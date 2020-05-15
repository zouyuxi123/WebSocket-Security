package com.demo.securitywebsocket.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.QueryChainWrapper;
import com.demo.securitywebsocket.bean.Role;
import com.demo.securitywebsocket.bean.User;
import com.demo.securitywebsocket.bean.UserRole;
import com.demo.securitywebsocket.mapper.RoleRepository;
import com.demo.securitywebsocket.mapper.UserRepository;
import com.demo.securitywebsocket.mapper.UserRoleRepository;
import com.mysql.cj.util.StringUtils;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: 邹玉玺
 * @date: 2020/5/13-10:18
 */
@Service
@Transactional
@AllArgsConstructor
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        if (StringUtils.isEmptyOrWhitespaceOnly(userName)){
            throw new UsernameNotFoundException("用户名不能为空");
        }
        //获取用户
        User user = userRepository.selectOne(new QueryWrapper<User>().lambda().eq(User::getUserName, userName));
        if (user==null){
            throw new UsernameNotFoundException("该用户不存在");
        }
        //获取用户对应权限信息
        List<UserRole> userRoles = userRoleRepository.selectList(new QueryWrapper<UserRole>().lambda().eq(UserRole::getUserId, user.getId()));
        if (userRoles!=null &&!userRoles.isEmpty()){
            List<Integer> rolesIds = userRoles.stream().map(UserRole::getRoleId).collect(Collectors.toList());
            List<Role> roles = roleRepository.selectList(new QueryWrapper<Role>().lambda().in(Role::getId, rolesIds));
            user.setRoles(roles);
        }
        return user;
    }


}
