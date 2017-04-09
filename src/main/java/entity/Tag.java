package entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/9.
 */
@Entity
public class Tag extends BaseEntity {
    private String name;

    @ManyToMany
    @JsonIgnore
    private List<Content> contents=new ArrayList<>();

    @ManyToMany(mappedBy = "tags",fetch = FetchType.LAZY)
    private List<Section> sections=new ArrayList<>();

    public Tag() {
    }

    public Tag(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Content> getContents() {return contents;}

    public void setContents(List<Content> contents) {this.contents = contents;}

    public List<Section> getSections() {return sections;}

    public void setSections(List<Section> sections) {this.sections = sections;}
}
