package entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Created by Administrator on 2017/4/9.
 */
@MappedSuperclass
public class BaseEntity implements Serializable{
    @Id
    @GeneratedValue(generator = "UUID2_GENERATOR")
    protected String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
