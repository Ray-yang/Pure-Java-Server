package org.ray.JClass.base.websocket;

import java.net.Socket;
import java.util.List;

import org.ray.JClass.base.websocket.drafts.Draft;

public interface WebSocketFactory {
	public WebSocket createWebSocket( WebSocketAdapter a, Draft d, Socket s );
	public WebSocket createWebSocket( WebSocketAdapter a, List<Draft> drafts, Socket s );

}
