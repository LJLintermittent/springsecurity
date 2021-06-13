package com.learn.securitydemo1.controller;

import com.learn.securitydemo1.entity.Users;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/24 20:50<br/>
 *
 * @author ${李佳乐}<br/>
 * @since JDK 1.8
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @GetMapping("hello")
    public String hello() {
        return "hello security!!";
    }

    @GetMapping("index")
    public String index() {
        return "hello index";
    }

    @GetMapping("update")
//    @Secured({"ROLE_sale","ROLE_boss"})
//    @PreAuthorize("hasAnyAuthority('sale')")
    @PostAuthorize("hasAnyAuthority('boss')")
    public String update() {
        log.info("方法已经执行.....");
        return "hello update";
    }

    @GetMapping("get")
    @PostAuthorize("hasAnyAuthority('sale')")
    @PostFilter("filterObject.username == 'admin1'")
    public List<Users> getAllUsers() {
        ArrayList<Users> list = new ArrayList<>();
        list.add(new Users(11, "admin1", "123"));
        list.add(new Users(22, "admin2", "123"));
        System.out.println(list);
        return list;
    }

}
