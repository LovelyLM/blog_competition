package com.leiming.blog.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String personalSign;
    private String image;
    private String createTime;
    private String imageOriginal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPersonalSign() {
        return personalSign;
    }

    public void setPersonalSign(String personalSign) {
        this.personalSign = personalSign;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getImageOriginal() {
        return imageOriginal;
    }

    public void setImageOriginal(String imageOriginal) {
        this.imageOriginal = imageOriginal;
    }

    public Set<Mood> getMoods() {
        return moods;
    }

    public void setMoods(Set<Mood> moods) {
        this.moods = moods;
    }

    public User() {
    }

    public User(String username, String password, String personalSign, String image, String createTime, String imageOriginal, Set<Mood> moods) {
        this.username = username;
        this.password = password;
        this.personalSign = personalSign;
        this.image = image;
        this.createTime = createTime;
        this.imageOriginal = imageOriginal;
        this.moods = moods;
    }

    @OneToMany(targetEntity = Mood.class)
    @JoinColumn(name = "user_id")
    private Set<Mood> moods = new HashSet<>();

}
