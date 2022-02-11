import connection.abstracts.RockScrapy;

import connection.concretes.Scrapy;
import exception.InvalidURLFormatException;
import html.abstracts.Tag;
import html.concretes.ClosableTag;
import html.concretes.TagProperty;


import java.io.IOException;
import java.net.MalformedURLException;

public class TestMain {
    public static void main(String[] args) throws IOException, InvalidURLFormatException {
        TagProperty property = new TagProperty();
        property.insert("name","propertyName");
        property.insert("value","con-as-material");

        TagProperty propertyClassMain = new TagProperty();
        propertyClassMain.insert("name","Class-asdd");
        propertyClassMain.insert("value","omni122");

        Tag html = new ClosableTag("html");
        Tag body = new ClosableTag("body");
        Tag classT = new ClosableTag("class",property);
        Tag classMain = new ClosableTag("div",propertyClassMain);

        classT.insertIntoTag(classMain);
        body.insertIntoTag(classT);
        html.insertIntoTag(body);
        System.out.println(html.toString());

    }
}
