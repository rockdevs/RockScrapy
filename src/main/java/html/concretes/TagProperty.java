package html.concretes;

import java.util.HashMap;
import java.util.Map;

public class TagProperty {
    private final Map<String,String> properties;

    public TagProperty(){
        properties = new HashMap<>();
    }


    public TagProperty(Map<String,String> properties){
        this.properties = properties;
    }

    public boolean hasProperty(){
        return !properties.isEmpty();
    }

    public void insert(String propertyName,String propertyContext){
        properties.putIfAbsent(propertyName,propertyContext);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("");
        for (String name: properties.keySet()){
            stringBuilder.append(" " + name + "=\""+properties.get(name)+"\"");
        }
        return stringBuilder.toString();
    }
}
