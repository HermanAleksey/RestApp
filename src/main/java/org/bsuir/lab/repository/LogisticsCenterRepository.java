package org.bsuir.lab.repository;

import org.bsuir.lab.domain.Driver;
import org.bsuir.lab.domain.LogisticsCenter;
import org.bsuir.lab.domain.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface LogisticsCenterRepository  extends CrudRepository<LogisticsCenter, Long> {

    List<LogisticsCenter> findLogisticsCenterById (int id);

    List<LogisticsCenter> findLogisticsCenterByLocation (String location);

    List<LogisticsCenter> findLogisticsCenterByName (String name);

    @Transactional
    List<LogisticsCenter> deleteLogisticsCenterById(int id);
}
