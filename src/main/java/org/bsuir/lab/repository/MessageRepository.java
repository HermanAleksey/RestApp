package org.bsuir.lab.repository;

import org.bsuir.lab.domain.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//tutorial: https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/jpa.repositories.html#jpa.query-methods.query-creation

public interface MessageRepository extends CrudRepository<Message, Long> {

    List<Message> findByTag (String tag);
}
