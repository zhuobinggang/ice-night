package hello.pojo;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/1/25.
 */

@Entity
@Table(name = "manga")
public class Manga {
    private long id;
    private String name;
    private String comment;
    private String logo_path;
    private String url;

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getLogoPath() {
        return logo_path;
    }

    public void setLogoPath(String logoPath) {
        this.logo_path = logoPath;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }
}
