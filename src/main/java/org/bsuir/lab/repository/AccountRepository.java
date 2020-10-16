package org.bsuir.lab.repository;

import org.bsuir.lab.domain.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountRepository  extends CrudRepository<Account, Long> {

    List<Account> findByLogin (String login);

    List<Account> findByPassword (String password);

    List<Account> findByRole (String role);

    List<Account> findAccountById(int id);

//    void deleteAccountById (int id);

}
