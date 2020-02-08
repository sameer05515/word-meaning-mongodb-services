package io.codementor.gtommee.rest_tutorial.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import io.codementor.gtommee.rest_tutorial.models.Type;

public interface TypeRepository extends MongoRepository<Type, String> {
  Type findBy_id(ObjectId _id);
}