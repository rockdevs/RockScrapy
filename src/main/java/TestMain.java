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
        Tag html = new ClosableTag("html");
        Tag div = new ClosableTag("div",property);

        html.insertIntoTag(div);
        System.out.println(html.toString());
    }
}
