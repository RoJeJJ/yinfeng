package com.roje.manager.configuration.security;

import com.roje.manager.common.ResultCode;
import com.roje.manager.utils.HttpUtils;
import org.springframework.security.web.session.InvalidSessionStrategy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Ro
 */
public class DefaultInvalidSessionStrategy implements InvalidSessionStrategy {
    @Override
    public void onInvalidSessionDetected(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpUtils.sendJsonData(ResultCode.SESSION_TIMEOUT, response);
    }
}
