package org.bsuir.lab.repository;

import org.bsuir.lab.domain.LogisticsCenter;
import org.bsuir.lab.domain.Message;
import org.bsuir.lab.domain.Operator;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OperatorRepository  extends CrudRepository<Operator, Long> {

    List<Operator> findOperatorById (int id);

    List<Operator> findOperatorByFio (String fio);

    List<Operator> findOperatorByPhoneNumber (String phone);

    List<Operator> findOperatorByAccount_Id (int id);

    @Transactional
    List<Operator> deleteOperatorById (int id);

}
