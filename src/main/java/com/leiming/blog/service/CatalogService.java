package com.leiming.blog.service;

import com.leiming.blog.domain.Catalog;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CatalogService {
    void saveCatalog(Catalog catalog);

    Catalog findCatalogByCatalog(String catalog);

    List<Catalog> findAllCatalog();
}
