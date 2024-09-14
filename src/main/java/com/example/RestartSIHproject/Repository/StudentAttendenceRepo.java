package com.example.RestartSIHproject.Repository;

import com.example.RestartSIHproject.Utility.StudentAttendence;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.io.ObjectInput;

public interface StudentAttendenceRepo extends MongoRepository<StudentAttendence, ObjectId> {

}
