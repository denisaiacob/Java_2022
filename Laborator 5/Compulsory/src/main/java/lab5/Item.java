package lab5;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Item implements Serializable {
    private String id;
    private String title;
    private String location; //file name or Web page
    private String type;

    private Map<String, Object> tags = new HashMap<>();

    public Item() {

    }

    public Item(String type,String id,String title,String location){
        this.type=type;
        this.id=id;
        this.location=location;
        this.title=title;
    }

    public Item(String key,Object object)
    {
        tags.put(key, object);
    }

    public void addTag(String key, Object obj) {
        tags.put(key, obj);
    }
  public String getId()
  {
      return id;
  }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", location='" + location + '\'' +
                ", type='" + type + '\'' +
                ", tags=" + tags +
                '}' + "\n";
    }
}

