package com.datastax.examples.spring.webservice.model;

import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;


@Table(value = "person")
public class Person implements Serializable {
  @PrimaryKey
  @CassandraType(type = CassandraType.Name.TEXT)
  private String username;

  @Column("firstname")
  @CassandraType(type = CassandraType.Name.TEXT)
  private String firstname;

  @Column("lastname")
  @CassandraType(type = CassandraType.Name.TEXT)
  private String lastname;

  public Person(String username, String firstname, String lastname){
    this.username = username;
    this.firstname = firstname;
    this.lastname = lastname;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  @Override
  public String toString() {
    return "Person [username=" + username + ", firstname=" + firstname + ", lastname=" + lastname + "]";
  }
}
