package com.learn.security;

import com.learn.utils.R;
import com.learn.utils.ResponseUtil;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/30 20:46<br/>
 *
 * @author ${李佳乐}<br/>
 * @since JDK 1.8
 */
public class UnAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest
            , HttpServletResponse httpServletResponse, AuthenticationException e)
            throws IOException, ServletException {
        ResponseUtil.out(httpServletResponse, R.error());
    }

}
