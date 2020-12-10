package com.datastax.examples.spring.webservice.repository;

import com.datastax.examples.spring.webservice.model.Person;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;


@Repository
@RestResource(exported = false)
public interface PersonRepository extends CassandraRepository<Person, String> {
  //findAll, findById, deleteAll, delete are already defined!
}
