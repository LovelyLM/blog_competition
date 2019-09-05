package com.leiming.blog.domain;

import javax.persistence.*;

@Entity
public class BlogComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private String creatTime;
    @ManyToOne(targetEntity = Blog.class)
    @JoinColumn(name = "blog_id")
    private Blog blog;


    @ManyToOne(targetEntity = Visitor.class)
    @JoinColumn(name = "visitor_id")
    private Visitor visitor;

    protected BlogComment (){

    }
    public BlogComment(String content, String creatTime, Blog blog, Visitor visitor) {
        this.content = content;
        this.creatTime = creatTime;
        this.blog = blog;
        this.visitor = visitor;
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

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public Visitor getVisitor() {
        return visitor;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }
}
