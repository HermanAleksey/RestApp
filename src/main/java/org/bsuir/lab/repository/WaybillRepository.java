package org.bsuir.lab.repository;

import org.bsuir.lab.domain.Message;
import org.bsuir.lab.domain.Waybill;
import org.springframework.data.repository.CrudRepository;

public interface WaybillRepository  extends CrudRepository<Waybill, Long> {
}
