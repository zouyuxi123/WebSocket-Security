package com.demo.securitywebsocket;
import com.demo.securitywebsocket.bean.Role;
import com.demo.securitywebsocket.bean.User;
import com.demo.securitywebsocket.bean.UserRole;
import com.demo.securitywebsocket.mapper.RoleRepository;
import com.demo.securitywebsocket.mapper.UserRepository;
import com.demo.securitywebsocket.mapper.UserRoleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SecurityWebsocketApplicationTests {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;

    @Test
    public void contextLoads() {
        System.out.println(0);
        System.out.println(userRepository);
    }
@Test
    public void initData() {
    List<User> userList = new ArrayList<>();
    List<Role> roleList = new ArrayList<>();
    List<UserRole> userRoleList = new ArrayList<>();
    userList.add(new User("user",new BCryptPasswordEncoder().encode("123456")));
    userList.add(new User("admin",new BCryptPasswordEncoder().encode("123456")));
    roleList.add(new Role("ROLE_ADMIN"));
    roleList.add(new Role("ROLE_SYSTEM"));

    userRoleList.add(new UserRole(1,1));
    userRoleList.add(new UserRole(1,2));
    userRoleList.add(new UserRole(2,2));

    userList.forEach(userRepository::insert);
    roleList.forEach(roleRepository::insert);
    userRoleList.forEach(userRoleRepository::insert);

}
}
