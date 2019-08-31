package com.leiming.blog.service.impl;

import com.leiming.blog.domain.Catalog;
import com.leiming.blog.repository.CatalogRepository;
import com.leiming.blog.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CatalogServiceImpl implements CatalogService {
    @Autowired
    private CatalogRepository catalogRepository;
    @Override
    public void saveCatalog(Catalog catalog) {
        catalogRepository.save(catalog);
    }

    @Override
    public Catalog findCatalogByCatalog(String catalog) {
        return catalogRepository.findCatalogByCatalog(catalog);
    }

    @Override
    public List<Catalog> findAllCatalog() {
        return (List<Catalog>) catalogRepository.findAll();
    }
}
