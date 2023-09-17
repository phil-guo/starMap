//package com.act.core.websocket;
//
//import com.act.core.utils.FriendlyException;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//
//import javax.websocket.*;
//import javax.websocket.server.PathParam;
//import javax.websocket.server.ServerEndpoint;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.CopyOnWriteArraySet;
//
//@ServerEndpoint("/websocket/{pageId}")
//@Component
//@Slf4j
//public class WebSocketSever {
//
//    // 与某个客户端的连接会话，需要通过它来给客户端发送数据
//    private Session session;
//
//    // session集合,存放对应的session
//    private static ConcurrentHashMap<Integer, Session> sessionPool = new ConcurrentHashMap<>();
//
//    // concurrent包的线程安全Set,用来存放每个客户端对应的WebSocket对象。
//    private static CopyOnWriteArraySet<WebSocketSever> webSocketSet = new CopyOnWriteArraySet<>();
//
//    /**
//     * 建立WebSocket连接
//     *
//     * @param session
//     * @param pageId  页面ID
//     */
//    @OnOpen
//    public void onOpen(Session session, @PathParam(value = "pageId") Integer pageId) {
//        log.info("WebSocket建立连接中,连接页面ID：{}", pageId);
//        Session historySession = sessionPool.get(pageId);
//        // historySession不为空,说明已经有页面链接,应该删除链接的WebSocket对象
//        if (historySession != null) {
////                webSocketSet.remove(historySession);
////                historySession.close();
//            return;
//        }
//        // 建立连接
//        this.session = session;
//        webSocketSet.add(this);
//        sessionPool.put(pageId, session);
//        log.info("建立连接完成");
//    }
//
//    /**
//     * 发生错误
//     *
//     * @param throwable e
//     */
//    @OnError
//    public void onError(Throwable throwable) {
//        throw new FriendlyException(throwable.getMessage());
//    }
//
//    /**
//     * 连接关闭
//     */
//    @OnClose
//    public void onClose() {
//        webSocketSet.remove(this);
//    }
//
//    /**
//     * 接收客户端消息
//     *
//     * @param message 接收的消息
//     */
//    @OnMessage
//    public void onMessage(String message) {
//        log.info("收到客户端发来的消息：{}", message);
//    }
//
//    /**
//     * 推送消息到指定页面
//     *
//     * @param pageId  页面ID
//     * @param message 发送的消息
//     */
//    public static void sendMessage(Integer pageId, HashMap<String,String> message) {
//        log.info("页面ID：" + pageId + ",推送内容：" + message);
//        Session session = sessionPool.get(pageId);
//        try {
//            session.getBasicRemote().sendObject(message);
//        } catch (IOException e) {
//            log.error("推送消息到指定页面发生错误：" + e.getMessage(), e);
//        } catch (EncodeException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    /**
//     * 群发消息
//     *
//     * @param message 发送的消息
//     */
//    public static void sendAllMessage(String message) {
//        log.info("发送消息：{}", message);
//        for (WebSocketSever webSocket : webSocketSet) {
//            try {
//                webSocket.session.getBasicRemote().sendText(message);
//            } catch (IOException e) {
//                log.error("群发消息发生错误：" + e.getMessage(), e);
//            }
//        }
//    }
//}
