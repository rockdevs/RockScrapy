package html.concretes;

import html.abstracts.Tag;

public class ClosableTag extends Tag {
    private Tag subTagContent = new NullTag();
    private String context = "";

    public ClosableTag(String tagName, TagProperty tagProperty) {
        super(tagName, tagProperty);
    }

    public ClosableTag(String tagName, TagProperty tagProperty,Tag subTagContent) {
        super(tagName, tagProperty);
        this.subTagContent=subTagContent;
    }

    public ClosableTag(String tagName, TagProperty tagProperty,Tag subTagContent,String context) {
        super(tagName, tagProperty);
        this.subTagContent=subTagContent;
        this.context=context;
    }

    public ClosableTag(String html) {
        super(html);
    }

    @Override
    public void insertIntoTag(Tag subTag) {
        this.subTagContent = subTag;
    }

    @Override
    public void insertIntoContext(String context) {
        this.context = context;
    }

    @Override
    public String toString() {
        return "\n<" + super.tagName + super.tagProperty+">" + context + subTagContent + "\n</" + super.tagName + ">";
    }
}
