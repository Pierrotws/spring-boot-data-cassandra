package com.datastax.examples.spring.webservice.model;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table(value = "tutorial")
public class Tutorial implements Serializable {

  @PrimaryKey
  @CassandraType(type = CassandraType.Name.TEXT)
  private UUID id;

  @Column("title")
  @CassandraType(type = CassandraType.Name.TEXT)
  private String title;

  @Column("description")
  @CassandraType(type = CassandraType.Name.TEXT)
  private String description;

  @Column("creator")
  @CassandraType(type = CassandraType.Name.TEXT)
  private String creator;

  public Tutorial(UUID id, String title, String description, String creator) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.creator = creator;
  }

  public void update(Tutorial withTutorial){
    this.setTitle(withTutorial.getTitle());
    this.setDescription(withTutorial.getDescription());
    this.setCreator(withTutorial.getCreator());
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getCreator() {
    return creator;
  }

  public void setCreator(String creator) {
    this.creator = creator;
  }

  @Override
  public String toString() {
    return "Tutorial [id=" + id + ", title=" + title + ", desc=" + description + ", creator=" + creator + "]";
  }
}
