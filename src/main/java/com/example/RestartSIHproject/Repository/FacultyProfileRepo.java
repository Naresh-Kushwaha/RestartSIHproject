package com.example.RestartSIHproject.Repository;

import com.example.RestartSIHproject.Model.FacultyProfileModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface FacultyProfileRepo  extends MongoRepository<FacultyProfileModel, ObjectId> {
    Optional<FacultyProfileModel> findByUsername(String username);
}
