package entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/9.
 */
@Entity
public class User extends BaseEntity {
    private String username;
    private String password;
    private String email;

    @OneToMany(mappedBy = "auto",fetch = FetchType.LAZY)
    private List<Course> courses =new ArrayList<>();
    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {return username;}

    public void setUsername(String username) {this.username = username;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public List<Course> getCourses() {return courses;}

    public void setCourses(List<Course> courses) {this.courses = courses;}
}
