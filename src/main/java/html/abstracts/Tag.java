package html.abstracts;

import html.concretes.TagProperty;


public abstract class Tag {
    protected int tabbedCount = 0;
    protected String tagName;
    protected TagProperty tagProperty;

    public Tag(){}


    public Tag(String tagName,TagProperty tagProperty){
        this.tagName=tagName;
        this.tagProperty=tagProperty;
    }

    public Tag(String tagName){
        this.tagName=tagName;
        this.tagProperty= new TagProperty();
    }

    public abstract Tag append(Tag subTag);

    public abstract void insertIntoContext(String context);
}
