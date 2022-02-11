package html.concretes;

import html.abstracts.Tag;

public class NullTag extends Tag {

    @Override
    public NullTag append(Tag subTag) {
        return this;
    }

    @Override
    public void insertIntoContext(String context) {

    }

    @Override
    public String toString() {
        return "";
    }
}
