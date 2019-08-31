package com.leiming.blog.repository;

import com.leiming.blog.domain.Catalog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CatalogRepository extends CrudRepository<Catalog,Long> {
    @Query(value = "select * from catalog where catalog =?1",nativeQuery = true)
    Catalog findCatalogByCatalog(String catalog);
}
