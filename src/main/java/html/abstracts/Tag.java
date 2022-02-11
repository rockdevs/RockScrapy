package html.abstracts;

import html.concretes.NullValueGenerator;
import html.concretes.TagProperty;


public abstract class Tag {
    protected String tagName;
    protected TagProperty tagProperty;

    public Tag(String tagName,TagProperty tagProperty){
        this.tagName=tagName;
        this.tagProperty=tagProperty;
    }

    public Tag(String tagName){
        this.tagName=tagName;
        this.tagProperty= NullValueGenerator.getEmptyProperty();
    }

    public abstract void insertIntoTag(Tag subTag);

    public abstract void insertIntoContext(String context);
}