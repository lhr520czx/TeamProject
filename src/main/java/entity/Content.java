package entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by 80561 on 2017/3/17.
 */
@Entity
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    @Column(name = "content",nullable = true, length = 100000000)
    private String content;
    private String author;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date time;

    @ManyToOne
    private User auto;

    @ManyToMany(mappedBy = "contents",fetch = FetchType.LAZY)
    private List<Tag> tags=new ArrayList<>();

    public User getAuto() {return auto;}

    public void setAuto(User auto) {this.auto = auto;}

    public List<Tag> getTags() {return tags;}

    public void setTags(List<Tag> tags) {this.tags = tags;}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
