package com.datastax.examples.spring.webservice.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;

//import org.springframework.data.cassandra.repository.AllowFiltering;


import com.datastax.examples.spring.webservice.model.Tutorial;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;


@Repository
//@RestResource(exported = false) //Uncomment to disable findAll, deleteAll auto
public interface TutorialRepository extends CassandraRepository<Tutorial, UUID> {
  //findAll, findById, deleteAll, delete are already defined!

  //annotate @AllowFiltering if not using Index (SAI recommended). AllowFiltering usage is discouraged
  List<Tutorial> findByCreator(String creator);
}
