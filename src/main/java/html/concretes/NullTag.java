package html.concretes;

import html.abstracts.Tag;

public class NullTag extends Tag {

    @Override
    public void insertIntoTag(Tag subTag) {

    }

    @Override
    public void insertIntoContext(String context) {

    }

    @Override
    public String toString() {
        return "";
    }
}
