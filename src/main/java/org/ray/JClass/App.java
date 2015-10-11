package org.ray.JClass;

import java.util.HashMap;
import java.util.Map;

import org.ray.JClass.base.http.server.NanoHTTPD;
import org.ray.JClass.base.http.server.NanoHTTPD.Response.Status;
import org.ray.JClass.base.http.server.ServerRunner;

import com.alibaba.fastjson.JSON;



public class App extends NanoHTTPD 
{
    public App() {
        super(80);
    }
    
    @Override
    public Response serve(IHTTPSession session) {
        
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("a", 1);
        resultMap.put("b", 2);
        resultMap.put("c", 3);
        
        return new Response(Status.OK, "application/json", JSON.toJSONString(resultMap));
    }

    public static void main( String[] args )
    {
        ServerRunner.run(App.class);
    }
}
