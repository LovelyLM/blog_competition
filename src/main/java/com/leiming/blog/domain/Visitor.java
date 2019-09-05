package com.leiming.blog.domain;

import javax.persistence.*;
import java.util.ArrayList;
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


    @OneToMany(targetEntity = BlogComment.class)
    @JoinColumn(name = "visitor_id")
    private List<BlogComment> blogComments = new ArrayList<>();

    protected Visitor(){

    }
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

    public List<BlogComment> getBlogComments() {
        return blogComments;
    }

    public void setBlogComments(List<BlogComment> blogComments) {
        this.blogComments = blogComments;
    }

    public Visitor(String image, String qq, String name, List<Message> messages, List<BlogComment> blogComments) {
        this.image = image;
        this.qq = qq;
        this.name = name;
        this.messages = messages;
        this.blogComments = blogComments;
    }
}
