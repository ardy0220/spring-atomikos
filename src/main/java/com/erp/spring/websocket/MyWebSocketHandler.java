package com.erp.spring.websocket;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Socket处理器
 *
 * @author Goofy
 * @Date 2015年6月11日 下午1:19:50
 */
@Component
public class MyWebSocketHandler implements WebSocketHandler {
    private static Logger logger = Logger.getLogger(MyWebSocketHandler.class);
    public static final Map<String, WebSocketSession> userSocketSessionMap;

    static {
        userSocketSessionMap = new HashMap<String, WebSocketSession>();
    }

    /**
     * 建立连接后
     */
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        String staffId = (String) session.getAttributes().get("staffId");
        logger.info("Websocket:用户[ID:" + staffId + "]已经建立连接");
        userSocketSessionMap.put(staffId, session);
    }

    /**
     * 消息处理，在客户端通过Websocket API发送的消息会经过这里，然后进行相应的处理
     */
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> webSocketMessage) throws Exception {
        if (webSocketMessage.getPayloadLength() == 0) return;
        String textMessage = webSocketMessage.getPayload().toString();
        String staffId = (String) session.getAttributes().get("staffId");
        logger.info("用户ID: " + staffId + ", 发送信息: " + textMessage);
        sendMsgToOtherUsers(staffId, new TextMessage(textMessage));
    }

    /**
     * 消息传输错误处理
     */
    public void handleTransportError(WebSocketSession session,
                                     Throwable exception) throws Exception {
        String staffId = (String) session.getAttributes().get("staffId");
        if (userSocketSessionMap.containsKey(staffId)) {
            userSocketSessionMap.remove(staffId);
            logger.info("Websocket会话已经移除, 用户ID: " + staffId);
        }
        if (session.isOpen()) {
            session.close();
        }
    }

    /**
     * 关闭连接后
     */
    public void afterConnectionClosed(WebSocketSession session,
                                      CloseStatus closeStatus) throws Exception {
        String staffId = (String) session.getAttributes().get("staffId");
        if (userSocketSessionMap.containsKey(staffId)) {
            userSocketSessionMap.remove(staffId);
            logger.info("用户ID: " + staffId + ", Websocket会话已经关闭");
        }
        if (session.isOpen()) {
            session.close();
        }
    }

    public boolean supportsPartialMessages() {
        return false;
    }

    /**
     *
     * @param fromUser
     * @param textMessage
     */
    public void sendMsgToOtherUsers(String fromUser, TextMessage textMessage) {

    }

}
