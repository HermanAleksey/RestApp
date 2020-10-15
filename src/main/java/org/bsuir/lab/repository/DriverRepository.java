package org.bsuir.lab.repository;

import org.bsuir.lab.domain.Driver;
import org.bsuir.lab.domain.Message;
import org.springframework.data.repository.CrudRepository;

public interface DriverRepository  extends CrudRepository<Driver, Long> {
}
