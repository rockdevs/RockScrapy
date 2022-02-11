import exception.InvalidURLFormatException;
import html.abstracts.Tag;
import html.concretes.ClosableTag;
import html.concretes.TagProperty;


import java.io.IOException;

public class TestMain {
    public static void main(String[] args) throws IOException, InvalidURLFormatException {
        TagProperty property = new TagProperty();
        property.insert("name","ClassPropertyName");
        property.insert("value","con-as-material");

        Tag html = new ClosableTag("html");
        Tag body = new ClosableTag("body");
        Tag classMain = new ClosableTag("class",property);
        Tag divFrame= new ClosableTag("div");
        Tag divFrameTwo = new ClosableTag("div");

        body.append(classMain);
        body.append(divFrame);
        html.append(body);

        System.out.println(html);
    }
}
