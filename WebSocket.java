package com.Socket;  
  
import java.io.IOException;  
import javax.websocket.*;  
import javax.websocket.server.PathParam;  
import javax.websocket.server.ServerEndpoint;  
  
@ServerEndpoint("/websocket")  
public class WebSocket {  
  
    private static int onlineCount = 0;  
    private Session session;  
      
    @OnOpen  
    public void onOpen(@PathParam("username") String username, Session session) throws IOException {  
  
        this.session = session;  
          
        addOnlineCount();  
        System.out.println("已连接");  
    }  
  
    @OnClose  
    public void onClose() throws IOException {  
        subOnlineCount();  
    }  
  
    @OnMessage  
    public void onMessage(String message) throws IOException {  
        System.out.println(message);
        sendMessageAll("你好");
    }  
  
    @OnError  
    public void onError(Session session, Throwable error) {  
        error.printStackTrace();  
    }  
  
      
    public void sendMessageAll(String message) throws IOException {  
        this.session.getAsyncRemote().sendText(message);  
    }  
      
      
  
    public static synchronized int getOnlineCount() {  
        return onlineCount;  
    }  
  
    public static synchronized void addOnlineCount() {  
        WebSocket.onlineCount++;  
    }  
  
    public static synchronized void subOnlineCount() {  
        WebSocket.onlineCount--;  
    }  
}
