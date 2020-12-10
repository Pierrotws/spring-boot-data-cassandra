
CREATE KEYSPACE IF NOT exists demo WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor': '3' } AND durable_writes = true;

CREATE TABLE IF NOT exists demo.tutorial (
  id uuid,
  title text,
  description text,
  creator text,
  PRIMARY KEY(id)
);

CREATE CUSTOM INDEX tutorial_creator_idx ON demo.tutorial (creator) USING 'StorageAttachedIndex'
WITH OPTIONS = {'case_sensitive': false, 'normalize': true, 'ascii': true };

CREATE TABLE IF NOT exists demo.person (
username text,
firstname text,
lastname text,
PRIMARY KEY(username)
);
