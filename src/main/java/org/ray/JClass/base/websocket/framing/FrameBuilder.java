package org.ray.JClass.base.websocket.framing;

import java.nio.ByteBuffer;

import org.ray.JClass.base.websocket.exceptions.InvalidDataException;

public interface FrameBuilder extends Framedata {

	public abstract void setFin( boolean fin );

	public abstract void setOptcode( Opcode optcode );

	public abstract void setPayload( ByteBuffer payload ) throws InvalidDataException;

	public abstract void setTransferemasked( boolean transferemasked );

}