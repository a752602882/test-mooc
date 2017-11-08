import java.io.*;
import java.util.Properties;

public class ProUnit {

     private Properties properties;
     private  String filePath;

     public  void  ProUnit(String filePath){
         this.filePath=filePath;
     }

     public  static void  main(String [] args){

     ProUnit pro = new ProUnit();
     //= pro.readProperties(pro.filePath);

    }


    public  Properties  readProperties( String path){


        try {
            Properties  properties = new Properties();
            FileInputStream in=new FileInputStream(path);
            InputStream input =new BufferedInputStream(in);
            properties.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
          return  properties;
    }

    /**
     * 解析配置文件
     * @param path
     */
    public  void getPro(){

            System.out.println(properties.getProperty("username"));
            String username_tag=properties.getProperty("username");
    }
}



