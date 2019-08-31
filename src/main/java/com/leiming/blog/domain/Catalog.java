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
    private Set<Blog> blogs =new HashSet<>();

    public Catalog(String catalog, Set<Blog> blogs) {
        this.catalog = catalog;
        this.blogs = blogs;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "id=" + id +
                ", catalog='" + catalog + '\'' +
                ", blogs=" + blogs +
                '}';
    }


    public Catalog(String catalog) {
        this.catalog = catalog;
    }

    public Catalog() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }
}
