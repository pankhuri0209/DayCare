package edu.neu.csye6200.repository;

import edu.neu.csye6200.model.AbstractPerson;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;


@NoRepositoryBean
public interface AbstractPersonRepository<T extends AbstractPerson> extends CrudRepository<T, Integer> {
}
