package org.bsuir.lab.repository;

import org.bsuir.lab.domain.Message;
import org.bsuir.lab.domain.Operator;
import org.springframework.data.repository.CrudRepository;

public interface OperatorRepository  extends CrudRepository<Operator, Long> {
}
