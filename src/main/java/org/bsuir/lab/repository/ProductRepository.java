package org.bsuir.lab.repository;

import org.bsuir.lab.domain.Message;
import org.bsuir.lab.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository  extends CrudRepository<Product, Long> {
}
