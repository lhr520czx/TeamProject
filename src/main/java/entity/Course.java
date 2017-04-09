package entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/9.
 */
@Entity
public class Course extends BaseEntity {
    private String name;
    @ManyToOne
    @JsonIgnore
    private User auto;

    @OneToMany(mappedBy = "course",fetch = FetchType.LAZY)
    private List<Section> sections=new ArrayList<>();

    public Course() {
    }

    public Course(String name) {this.name = name;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getAuto() {return auto;}

    public void setAuto(User auto) {this.auto = auto;}

    public List<Section> getSections() {return sections;}

    public void setSections(List<Section> sections) {this.sections = sections;}
}
