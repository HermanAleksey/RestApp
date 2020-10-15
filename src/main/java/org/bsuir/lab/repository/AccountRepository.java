package org.bsuir.lab.repository;

import org.bsuir.lab.domain.Account;
import org.bsuir.lab.domain.Message;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository  extends CrudRepository<Account, Long> {
}
