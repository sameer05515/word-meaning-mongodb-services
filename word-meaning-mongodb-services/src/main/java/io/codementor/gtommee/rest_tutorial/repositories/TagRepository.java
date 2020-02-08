package io.codementor.gtommee.rest_tutorial.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import io.codementor.gtommee.rest_tutorial.models.Tag;

public interface TagRepository extends MongoRepository<Tag, String> {
  Tag findBy_id(ObjectId _id);
}