package io.codementor.gtommee.rest_tutorial.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import io.codementor.gtommee.rest_tutorial.models.Word;

public interface WordsRepository extends MongoRepository<Word, String> {
  Word findBy_id(ObjectId _id);
}