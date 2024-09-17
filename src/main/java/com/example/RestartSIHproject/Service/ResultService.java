package com.example.RestartSIHproject.Service;


import com.example.RestartSIHproject.Model.FacultyProfileModel;
import com.example.RestartSIHproject.Repository.FacultyProfileRepo;
import com.example.RestartSIHproject.Repository.ResultRepo;
import com.example.RestartSIHproject.Utility.Result;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ResultService {
    @Autowired
    private FacultyProfileRepo facultyProfileRepo;
    @Autowired
    private ResultRepo resultRepo;

    private FacultyProfileModel getaFacultyProfileByUsername(String username){
        return facultyProfileRepo.findByUsername(username).orElseThrow(()->new IllegalArgumentException("faculty not found"));
    }
    @Transactional
    public ResponseEntity<?> addResult(Result result,String username){
         FacultyProfileModel facultyProfile=getaFacultyProfileByUsername(username);

            Result result1= resultRepo.save(result);


            facultyProfile.getPerformanceOfResult().add(result1);
            facultyProfileRepo.save(facultyProfile);
            return ResponseEntity.ok().build();


    }
    @Transactional
    public ResponseEntity<?> deleteResult(ObjectId id,String username){
      FacultyProfileModel facultyProfile=getaFacultyProfileByUsername(username);
            facultyProfile.getPerformanceOfResult().removeIf(x->x.getId().equals(id));

            resultRepo.deleteById(id);
            return ResponseEntity.ok().build();

    }
}
