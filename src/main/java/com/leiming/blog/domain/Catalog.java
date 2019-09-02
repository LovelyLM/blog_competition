package com.leiming.blog.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Catalog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String catalog;

    @ManyToMany(mappedBy = "catalogs")
    private Set<Blog> blogs = new HashSet<Blog>();

    protected Catalog() {

    }

    public Catalog(Long id, String catalog, Set<Blog> blogs) {
        super();
        this.id = id;
        this.catalog = catalog;
        this.blogs = blogs;
    }
    public Set<Blog> getBlogs() {
        return blogs;
    }
    public void setBlogs(Set<Blog> blogs) {
        this.blogs = blogs;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCatalog() {
        return catalog;
    }
    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }
}
