package Unit;

import java.io.*;
import java.util.Properties;

public class ProUnit {

     private Properties properties;
     private  String filePath;


    public  ProUnit(String filePath)
     {
         this.filePath=filePath;
         properties =readProperties(filePath);
     }



    /**
     *     读取文件
     * @param path
     * @return
     */
    public  Properties  readProperties( String path){

        Properties  properties = new Properties();
        try {
            FileInputStream in=new FileInputStream(path);
            InputStream input =new BufferedInputStream(in);
            properties.load(input);
            in.close();
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
          return  properties;
    }

    /**
     * 解析配置文件
     *
     */
    public  String getPro(String key){
           return properties.getProperty(key);
    }

    public void WritePro(String name, String value) {
          properties.setProperty(name,value);
    }
}



