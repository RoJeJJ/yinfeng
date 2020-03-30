package com.roje.manager.configuration.security;

import com.roje.manager.common.ResultCode;
import com.roje.manager.utils.HttpUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Ro
 */
public class DefaultAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        HttpUtils.sendJsonData(ResultCode.UNAUTHORIZED, response);
    }
}
