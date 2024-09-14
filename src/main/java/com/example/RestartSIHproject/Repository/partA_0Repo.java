package com.example.RestartSIHproject.Repository;

import com.example.RestartSIHproject.Utility.partA_0;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface partA_0Repo extends MongoRepository<partA_0, ObjectId>{
    @Override
    Optional<partA_0> findById(ObjectId objectId);
}
