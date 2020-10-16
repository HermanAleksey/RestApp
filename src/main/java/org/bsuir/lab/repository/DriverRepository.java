package org.bsuir.lab.repository;

import org.bsuir.lab.domain.Account;
import org.bsuir.lab.domain.Driver;
import org.bsuir.lab.domain.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DriverRepository  extends CrudRepository<Driver, Long> {

    List<Driver> findDriverByFio (String fio);

    List<Driver> findDriverByPhoneNumber (String phoneNumber);

    List<Driver> findDriverById(int id);

    void deleteDriverById(int id);
}
