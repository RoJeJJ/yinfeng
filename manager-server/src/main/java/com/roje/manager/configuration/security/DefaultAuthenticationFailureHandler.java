package com.roje.manager.configuration.security;

import com.roje.manager.common.ResultCode;
import com.roje.manager.common.exception.CaptchaException;
import com.roje.manager.utils.HttpUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Ro
 */
@Slf4j
public class DefaultAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException e) throws IOException, ServletException {
        log.debug("验证错误消息:" + e.getMessage());
        ResultCode resultCode = ResultCode.ERROR;
        if (e instanceof UsernameNotFoundException ||
                e instanceof BadCredentialsException) {
            resultCode = ResultCode.USERNAME_OR_PSW_ERROR;
        } else if (e instanceof CaptchaException) {
            resultCode = ResultCode.CAPTCHA_INVALID;
        }
        HttpUtils.sendJsonData(resultCode, response);
    }
}
