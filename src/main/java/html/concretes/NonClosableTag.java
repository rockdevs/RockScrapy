package html.concretes;

import html.abstracts.Tag;

public class NonClosableTag extends Tag {

    public NonClosableTag(String tagName, TagProperty tagProperty) {
        super(tagName, tagProperty);
    }

    @Override
    public NonClosableTag append(Tag subTag) {

        return this;
    }

    @Override
    public void insertIntoContext(String context) {

    }

    @Override
    public String toString() {
        return "\n<"+super.tagName+">";
    }
}
