package com.leiming.blog.domain;

import javax.persistence.*;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private String creatTime;
    @ManyToOne(targetEntity = Visitor.class)
    @JoinColumn(name = "visitor_id")
    private Visitor visitor;
    protected Message(){

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(String creatTime) {
        this.creatTime = creatTime;
    }

    public Visitor getVisitor() {
        return visitor;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    public Message(String content, String creatTime, Visitor visitor) {
        this.content = content;
        this.creatTime = creatTime;
        this.visitor = visitor;
    }
}
