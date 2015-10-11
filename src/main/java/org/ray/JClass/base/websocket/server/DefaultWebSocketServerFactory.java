package org.ray.JClass.base.websocket.server;

import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.List;

import org.ray.JClass.base.websocket.WebSocketAdapter;
import org.ray.JClass.base.websocket.WebSocketImpl;
import org.ray.JClass.base.websocket.drafts.Draft;
import org.ray.JClass.base.websocket.server.WebSocketServer.WebSocketServerFactory;

public class DefaultWebSocketServerFactory implements WebSocketServerFactory {
	@Override
	public WebSocketImpl createWebSocket( WebSocketAdapter a, Draft d, Socket s ) {
		return new WebSocketImpl( a, d );
	}
	@Override
	public WebSocketImpl createWebSocket( WebSocketAdapter a, List<Draft> d, Socket s ) {
		return new WebSocketImpl( a, d );
	}
	@Override
	public SocketChannel wrapChannel( SocketChannel channel, SelectionKey key ) {
		return (SocketChannel) channel;
	}
}