package org.ray.JClass.jvm;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;

public class JVMClassParser {

    public static String fileHEX(String filePath){
        
        byte[] classBinary = JVMClassParser.getClassBinary(filePath);
                
        BigInteger bigInteger = new BigInteger(1, classBinary);  
        return bigInteger.toString(16);  
    }
    
    public static byte[] getClassBinary(String filePath){
        File file = new File(filePath);
        byte[] buf = new byte[(int) file.length()];
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));){
            bis.read(buf);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buf;
    }
}
