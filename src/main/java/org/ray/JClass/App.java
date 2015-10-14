package org.ray.JClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

import org.ray.JClass.base.http.server.NanoHTTPD;
import org.ray.JClass.base.http.server.NanoHTTPD.Response.Status;
import org.ray.JClass.base.http.server.ServerRunner;
import org.ray.JClass.base.websocket.WebSocket;
import org.ray.JClass.base.websocket.drafts.Draft_17;
import org.ray.JClass.jvm.JVMClassParser;

public class App extends NanoHTTPD {

    public static List<WebSocket> webSocketList = new CopyOnWriteArrayList<WebSocket>();
    
    public App() {
        super(80);
    }

    @Override
    public Response serve(IHTTPSession session) {
        Method method = session.getMethod();
        if ( Method.POST.equals(method) && session.getUri().startsWith("/upload") ) {
            Map<String, String> files = new HashMap<String, String>();  
            try {
                session.parseBody(files);
                String fileHEX = JVMClassParser.fileHEX(files.get("JvmClass"));
                
                return new Response(Status.OK, MIME_HTML, fileHEX);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        
        Response response =  new Response(Status.OK, MIME_HTML, "error");
        try {
            response = new Response(Status.OK, MIME_HTML, new FileInputStream("target/classes/index.html"));
            if ( null == session.getCookies().read("HTTPD_SESSION") ) {
                response.addHeader("Set-Cookie", "HTTPD_SESSION=" + UUID.randomUUID());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
        return response;
    }

    public static void main(String[] args) {
        try {
//            java.awt.Desktop.getDesktop().browse(new File("target/classes/chat.html").toURI());
            
            new JCWss(8887, new Draft_17()).start();
            ServerRunner.run(App.class);
            
        } catch (Exception e) {
        }

    }
}
