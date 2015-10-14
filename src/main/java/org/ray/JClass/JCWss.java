package org.ray.JClass;

import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Collections;

import org.ray.JClass.base.websocket.WebSocket;
import org.ray.JClass.base.websocket.drafts.Draft;
import org.ray.JClass.base.websocket.framing.FrameBuilder;
import org.ray.JClass.base.websocket.framing.Framedata;
import org.ray.JClass.base.websocket.handshake.ClientHandshake;
import org.ray.JClass.base.websocket.server.WebSocketServer;

public class JCWss extends WebSocketServer {
	private static int counter = 0;
	
	public JCWss( int port , Draft d ) throws UnknownHostException {
		super( new InetSocketAddress( port ), Collections.singletonList( d ) );
	}
	
	public JCWss( InetSocketAddress address, Draft d ) {
		super( address, Collections.singletonList( d ) );
	}

	@Override
	public void onOpen( WebSocket conn, ClientHandshake handshake ) {
		counter++;
		System.out.println( "///////////Opened connection number" + counter );
	}

	@Override
	public void onClose( WebSocket conn, int code, String reason, boolean remote ) {
		System.out.println( "closed" );
	}

	@Override
	public void onError( WebSocket conn, Exception ex ) {
		System.out.println( "Error:" );
		ex.printStackTrace();
	}

	@Override
	public void onMessage( WebSocket conn, String message ) {
		conn.send( message );
	}

	@Override
	public void onMessage( WebSocket conn, ByteBuffer blob ) {
		conn.send( blob );
	}

	@Override
	public void onWebsocketMessageFragment( WebSocket conn, Framedata frame ) {
		FrameBuilder builder = (FrameBuilder) frame;
		builder.setTransferemasked( false );
		conn.sendFrame( frame );
	}
}
