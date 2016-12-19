
package com.erp.spring.websocket;

import com.erp.entity.StaffInfo;
import org.apache.log4j.Logger;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;


/**
 * Socket建立连接（握手）和断开
 */
public class HandShake implements HandshakeInterceptor {
    private static Logger logger = Logger.getLogger(HandShake.class);

    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        logger.info("---------beforeHandshake---------");
        ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
        HttpServletRequest httpServletRequest = servletRequest.getServletRequest();
        String staffId = httpServletRequest.getParameter("staffId");
        logger.info("---------staffId: " + staffId + " ---------");
        // 标记用户
        if (staffId != null) {
            attributes.put("staffId", staffId);
        } else {
            return false;
        }
        return true;
    }

    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {
    }

}
