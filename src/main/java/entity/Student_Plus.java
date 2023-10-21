package entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "Students")
public class Student_Plus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "Image")
    private String linkImage;

    @Column(name = "Name")
    private String name;

    @Column(name = "Birth")
    private LocalDateTime birth;

    @Column(name = "Phone")
    private String phone;

    public Student_Plus() {
    }

    public Student_Plus(int id, String linkImage, String name, LocalDateTime birth, String phone) {
        this.id = id;
        this.linkImage = linkImage;
        this.name = name;
        this.birth = birth;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLinkImage() {
        return linkImage;
    }

    public void setLinkImage(String linkImage) {
        this.linkImage = linkImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getBirth() {
        return birth;
    }

    public void setBirth(LocalDateTime birth) {
        this.birth = birth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
