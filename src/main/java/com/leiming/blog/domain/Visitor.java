package com.leiming.blog.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Visitor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String image;
    private String qq;
    private String name;
    @OneToMany(targetEntity = Message.class)
    @JoinColumn(name = "visitor_id")
    private List<Message> messages;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    protected Visitor() {
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "id=" + id +
                ", image='" + image + '\'' +
                ", qq='" + qq + '\'' +
                ", name='" + name + '\'' +
                ", messages=" + messages +
                '}';
    }

    public Visitor(String image, String qq, String name, List<Message> messages) {
        this.image = image;
        this.qq = qq;
        this.name = name;
        this.messages = messages;
    }
}
