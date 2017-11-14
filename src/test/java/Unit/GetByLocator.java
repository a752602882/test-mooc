package Unit;

import org.openqa.selenium.By;

public class GetByLocator {
    public  static By  getByLocator(String key){
        ProUnit  prop = new ProUnit("element.properties");
        String tag = prop.getPro(key).split(">")[0];
        String value = prop.getPro(key).split(">")[1];

        if (tag.equals("name")){
            return  By.name(value);
        }else if(tag.equals("id")){
            return  By.id(value);
        }else if(tag.equals("className")){
            return  By.className(value);
        }else if(tag.equals("xpath")){
            return  By.xpath(value);
        }else if(tag.equals("linkText")){
            return  By.linkText(value);
        }else if(tag.equals("partialLinkText")){
            return  By.partialLinkText(value);
        }else if(tag.equals("tagName")){
            return  By.tagName(value);
        }else if(tag.equals("cssSelector")){
            return  By.cssSelector(value);
        } else{
            return null;
        }
    }
}
