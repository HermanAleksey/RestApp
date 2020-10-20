package org.bsuir.lab.repository;

import org.bsuir.lab.domain.Message;
import org.bsuir.lab.domain.Operator;
import org.bsuir.lab.domain.Waybill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface WaybillRepository  extends CrudRepository<Waybill, Long> {

    List<Waybill> findOperatorById (int id);

    List<Waybill> findWaybillByDateOfShipment (String str);

    List<Waybill> findWaybillByDateOfDelivery (String str);

    List<Waybill> findWaybillByDriverId (int id);

    List<Waybill> findWaybillByOperatorId (int id);

    @Transactional
    List<Waybill> deleteWaybillById (int id);

}
