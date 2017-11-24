package Unit;

import org.openqa.selenium.By;

public class GetByLocator {

    public  static By  getByLocator(String key){
        ProUnit  prop = new ProUnit("element.properties");
        String tag = prop.getPro(key).split(">")[0];
        String value = prop.getPro(key).split(">")[1];



        switch (tag){
            case "name":  return By.name(value);
            case "id": return  By.id(value);
            case "className": return By.className(value);
            case "xpath":return By.xpath(value);
            case "linkText":return  By.linkText(value);
            case "partialLinkText":return  By.partialLinkText(value);
            case "tagName":return  By.tagName(value);
            case "cssSelector":return  By.cssSelector(value);
            default:return  null;
        }



/*        if (tag.equals("name")){
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
        }*/
    }
}
