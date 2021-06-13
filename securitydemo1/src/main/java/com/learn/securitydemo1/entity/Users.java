package com.learn.securitydemo1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/25 10:18<br/>
 *
 * @author ${李佳乐}<br/>
 * @since JDK 1.8
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    private Integer id;
    private String username;
    private String password;
}
