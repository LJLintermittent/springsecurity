package com.learn.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/30 21:01<br/>
 *
 * @author ${李佳乐}<br/>
 * @since JDK 1.8
 */
@Data
@ApiModel(description = "用户实体类")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "微信openid")
    private String username;
    @ApiModelProperty(value = "密码")
    private String password;
    @ApiModelProperty(value = "昵称")
    private String nickName;
    @ApiModelProperty(value = "用户头像")
    private String salt;
    @ApiModelProperty(value = "用户签名")
    private String token;
}
