package org.bsuir.lab.repository;

import org.bsuir.lab.domain.Message;
import org.bsuir.lab.domain.Product;
import org.bsuir.lab.domain.Waybill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductRepository  extends CrudRepository<Product, Long> {
    List<Product> findProductById (int id);

    List<Product> findProductByArticle (String str);

    List<Product> findProductByTitle (String str);

    List<Product> findProductByAmount (int id);

    List<Product> findProductByWaybillId (int id);

    @Transactional
    List<Product> deleteProductById (int id);
}
