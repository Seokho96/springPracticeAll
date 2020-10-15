package bit.com.a.websock;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

// web socket Server   (= web network Server)
@Component 
public class WebSocket extends TextWebSocketHandler {
	
	private Map<String, WebSocketSession> users = new ConcurrentHashMap<String, WebSocketSession>();
	
	public WebSocket() {
		System.out.println("EchoHandler 생성됨" + new Date());
	}

	// 연결이 된 후 실행 ( = accept)
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
	      System.out.println("연결됨" + session.getId() + " " + new Date());
	      users.put(session.getId(), session);
	}
    
	// 연결이 종료됐을 때 실행
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		 System.out.println("연결종료" + session.getId());
		 users.remove(session.getId());
	}

	// 메시지를 수신
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		
		System.out.print("메시지 수신" + message.getPayload() + " " + new Date());
		
		// 송신(send)
		for (WebSocketSession s : users.values()) {
			s.sendMessage(message);
			
		}
	}

	// 예외가 발생했을 때 실행
	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		System.out.println(session.getId() + "Exception 발생" + new Date());
	}
	
	
	
	

}
