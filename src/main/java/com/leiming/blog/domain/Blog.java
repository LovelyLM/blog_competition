package com.leiming.blog.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String createTime;
    private Long viewNumber;
    private Long commentNumber;
    private String cover;
    private String image;
    private String littleTitle;
    private String littleContent;
    @ManyToOne(targetEntity = Mood.class)
    @JoinColumn(name = "mood_id")
    private Mood mood;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "blog_catalog",
            joinColumns = @JoinColumn(name = "blog_id"),
            inverseJoinColumns = @JoinColumn(name = "catalog_id")
    )
    private Set<Catalog> catalogs = new HashSet<Catalog>();


    @OneToMany(targetEntity = BlogComment.class)
    @JoinColumn(name = "blog_id")
    private List<BlogComment> blogComments = new ArrayList<>();


    protected Blog() {

    }

    public Blog(Long id, String title, String content, String createTime, Long viewNumber, Long commentNumber,
                String cover, String image, String littleTitle, String littleContent, Mood mood,
                List<BlogComment> blogComments, Set<Catalog> catalogs) {
        super();
        this.id = id;
        this.title = title;
        this.content = content;
        this.createTime = createTime;
        this.viewNumber = viewNumber;
        this.commentNumber = commentNumber;
        this.cover = cover;
        this.image = image;
        this.littleTitle = littleTitle;
        this.littleContent = littleContent;
        this.mood = mood;
        this.blogComments = blogComments;
        this.catalogs = catalogs;
    }

    public List<BlogComment> getBlogComments() {
        return blogComments;
    }

    public void setBlogComments(List<BlogComment> blogComments) {
        this.blogComments = blogComments;
    }

    public Set<Catalog> getCatalogs() {
        return catalogs;
    }

    public void setCatalogs(Set<Catalog> catalogs) {
        this.catalogs = catalogs;
    }

    public Mood getMood() {
        return mood;
    }

    public void setMood(Mood mood) {
        this.mood = mood;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Long getViewNumber() {
        return viewNumber;
    }

    public void setViewNumber(Long viewNumber) {
        this.viewNumber = viewNumber;
    }

    public Long getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(Long commentNumber) {
        this.commentNumber = commentNumber;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLittleTitle() {
        return littleTitle;
    }

    public void setLittleTitle(String littleTitle) {
        this.littleTitle = littleTitle;
    }

    public String getLittleContent() {
        return littleContent;
    }

    public void setLittleContent(String littleContent) {
        this.littleContent = littleContent;
    }

    @Override
    public String toString() {
        return "Blog [id=" + id + ", title=" + title + ", content=" + content + ", createTime=" + createTime
                + ", viewNumber=" + viewNumber + ", commentNumber=" + commentNumber + ", cover=" + cover + ", image="
                + image + ", littleTitle=" + littleTitle + ", littleContent=" + littleContent + ", mood=" + mood
                + ", catalogs=" + catalogs + "]";
    }
}
