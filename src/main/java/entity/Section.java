package entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/4/9.
 */
@Entity
public class Section extends BaseEntity {
    private String title;
    private String introduction;
    private int orderIndex;
    @ManyToOne
    @JsonIgnore
    private Course course;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<Tag> tags =new HashSet<>();


    public Section() {
    }

    public Section(String title, String introduction) {
        this.title = title;
        this.introduction = introduction;
    }

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public String getIntroduction() {return introduction;}

    public void setIntroduction(String introduction) {this.introduction = introduction;}

    public int getOrderIndex() {return orderIndex;}

    public void setOrderIndex(int orderIndex) {this.orderIndex = orderIndex;}

    public Course getCourse() {return course;}

    public void setCourse(Course course) {this.course = course;}

    public Set<Tag> getTags() {return tags;}

    public void setTags(Set<Tag> tags) {this.tags = tags;}
}
