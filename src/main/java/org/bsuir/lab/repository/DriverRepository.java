package org.bsuir.lab.repository;

import org.bsuir.lab.domain.Account;
import org.bsuir.lab.domain.Driver;
import org.bsuir.lab.domain.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DriverRepository  extends CrudRepository<Driver, Long> {

    List<Driver> findDriverById(int id);

    List<Driver> findDriverByFio (String fio);

    List<Driver> findDriverByPhoneNumber (String phoneNumber);

    @Transactional
    List<Driver> deleteDriverById(int id);
}
