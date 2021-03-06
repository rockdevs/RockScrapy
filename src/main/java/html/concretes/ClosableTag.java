package html.concretes;

import html.abstracts.Tag;

import java.util.ArrayList;
import java.util.List;

public class ClosableTag extends Tag {
    private final List<Tag> subTags  = new ArrayList<>();
    private String context = "";

    public ClosableTag(String tagName, TagProperty tagProperty) {
        super(tagName, tagProperty);
        this.subTags.add(new NullTag());
    }

    public ClosableTag(String tagName, TagProperty tagProperty,Tag subTagContent) {
        super(tagName, tagProperty);
        this.subTags.add(subTagContent);
    }

    public ClosableTag(String tagName, TagProperty tagProperty,Tag subTagContent,String context) {
        super(tagName, tagProperty);
        this.subTags.add(subTagContent);
        this.context=context;
    }

    public ClosableTag(String tagname) {
        super(tagname);
        this.subTags.add(new NullTag());
    }

    @Override
    public ClosableTag append(Tag subTag) {
        super.tabbedCount++;
        this.subTags.add(subTag);
        return this;
    }

    @Override
    public void insertIntoContext(String context) {
        this.context = context;
    }

    @Override
    public String toString() {
        return this.subTagsRefactor();
    }

    private String subTagsRefactor(){
        String tabbed = this.tabbedFactory();
        if(this.subTags.size()>1){
            StringBuilder result = new StringBuilder("");
            for (Tag tag:this.subTags){
                result.append(tag.toString());
            }
            System.err.println(result.toString());
            return result.toString();
        }else {
            return ("\n"  + "<" + super.tagName + super.tagProperty+">" + context + subTags.get(0) + "\n</" + super.tagName + ">");
        }
    }

    private String tabbedFactory(){
        StringBuilder con =new StringBuilder("");
        for (int i = 0;i <= super.tabbedCount;i++){
            con.append("\t");
        }
        return con.toString();
    }
}
