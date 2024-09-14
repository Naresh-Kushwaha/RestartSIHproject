package com.example.RestartSIHproject.Repository;

import com.example.RestartSIHproject.Utility.Result;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ResultRepo extends MongoRepository<Result, ObjectId> {

}
