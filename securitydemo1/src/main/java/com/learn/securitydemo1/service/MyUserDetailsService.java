package com.learn.securitydemo1.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.learn.securitydemo1.entity.Users;
import com.learn.securitydemo1.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/24 21:51<br/>
 *
 * @author ${李佳乐}<br/>
 * @since JDK 1.8
 */
@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        Users users = usersMapper.selectOne(wrapper);
        if (users == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        List<GrantedAuthority> authorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_manager,ROLE_admin,sale");
//        return new User("LiJiaLe",
//        new BCryptPasswordEncoder().encode("123"), authorities);
        return new User(users.getUsername(),
                new BCryptPasswordEncoder().encode(users.getPassword()), authorities);
    }
}
