package com.example.RestartSIHproject.Service;


import com.example.RestartSIHproject.Model.FacultyProfileModel;
import com.example.RestartSIHproject.Repository.FacultyProfileRepo;
import com.example.RestartSIHproject.Repository.partA_0Repo;
import com.example.RestartSIHproject.Utility.partA_0;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class partA_0Service {
    @Autowired
    private partA_0Repo partA_0Repo;
    @Autowired
    private FacultyProfileRepo facultyProfileRepo;

    public ResponseEntity<?>AddPartA_0(partA_0 partA0 ,String username){
        Optional<FacultyProfileModel> facultyProfileModel=facultyProfileRepo.findByUsername(username);
        if(facultyProfileModel.isPresent()){
            FacultyProfileModel facultyProfile=facultyProfileModel.get();
            partA_0 partA01=partA_0Repo.save(partA0);

            facultyProfile.setPartA_0(partA01);
            facultyProfileRepo.save(facultyProfile);
            return  ResponseEntity.ok().build();

        }
        else{
            return ResponseEntity.notFound().build();
        }


    }
    public  ResponseEntity<?>DeletePartA_0(ObjectId id,String username){
        Optional<FacultyProfileModel> facultyProfileModel=facultyProfileRepo.findByUsername(username);
        if(facultyProfileModel.isPresent()){
            FacultyProfileModel facultyProfil= facultyProfileModel.get();
            facultyProfil.getPerformanceOfEngagingLectures().removeIf(x->x.getId().equals(id));
            facultyProfileRepo.save(facultyProfil);
            partA_0Repo.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

}
