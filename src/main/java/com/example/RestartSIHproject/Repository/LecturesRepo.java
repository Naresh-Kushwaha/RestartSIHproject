package com.example.RestartSIHproject.Repository;

import com.example.RestartSIHproject.Utility.Lectures;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface LecturesRepo extends MongoRepository<Lectures, ObjectId> {
    @Override
    Optional<Lectures> findById(ObjectId Id);
}
