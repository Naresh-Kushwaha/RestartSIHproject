package com.example.RestartSIHproject.Service;


import com.example.RestartSIHproject.Model.FacultyProfileModel;
import com.example.RestartSIHproject.Repository.FacultyProfileRepo;
import com.example.RestartSIHproject.Repository.ResultRepo;
import com.example.RestartSIHproject.Utility.Result;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResultService {
    @Autowired
    private FacultyProfileRepo facultyProfileRepo;
    @Autowired
    private ResultRepo resultRepo;

    public ResponseEntity<?> addResult(Result result,String username){
        Optional<FacultyProfileModel> facultyProfileModel=facultyProfileRepo.findByUsername(username);
        if(facultyProfileModel.isPresent()){
            FacultyProfileModel facultyProfile= facultyProfileModel.get();
            Result result1= resultRepo.save(result);


            facultyProfile.getPerformanceOfResult().add(result1);
            facultyProfileRepo.save(facultyProfile);
            return ResponseEntity.ok().build();


        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
    public ResponseEntity<?> deleteResult(ObjectId id,String username){
        Optional<FacultyProfileModel> facultyProfileModel=facultyProfileRepo.findByUsername(username);
        if(facultyProfileModel.isPresent()){
            FacultyProfileModel facultyProfile= facultyProfileModel.get();
            facultyProfile.getPerformanceOfResult().removeIf(x->x.getId().equals(id));

            resultRepo.deleteById(id);
            return ResponseEntity.ok().build();

        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}
