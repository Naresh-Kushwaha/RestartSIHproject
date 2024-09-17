package com.example.RestartSIHproject.Service;


import com.example.RestartSIHproject.Model.FacultyProfileModel;
import com.example.RestartSIHproject.Repository.FacultyProfileRepo;
import com.example.RestartSIHproject.Repository.partA_0Repo;
import com.example.RestartSIHproject.Utility.partA_0;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class partA_0Service {
    @Autowired
    private partA_0Repo partA_0Repo;
    @Autowired
    private FacultyProfileRepo facultyProfileRepo;
    private FacultyProfileModel getaFacultyProfileByUsername(String username){
        return facultyProfileRepo.findByUsername(username).orElseThrow(()->new IllegalArgumentException("faculty not found"));
    }

    @Transactional
    public ResponseEntity<?>AddPartA_0(partA_0 partA0 ,String username){
     FacultyProfileModel facultyProfile=getaFacultyProfileByUsername(username);

            partA_0 partA01=partA_0Repo.save(partA0);

            facultyProfile.setPartA_0(partA01);
            facultyProfileRepo.save(facultyProfile);
            return  ResponseEntity.ok().build();




    }
    @Transactional
    public  ResponseEntity<?>DeletePartA_0(ObjectId id,String username){
        FacultyProfileModel facultyProfil =getaFacultyProfileByUsername(username);
            facultyProfil.getPerformanceOfEngagingLectures().removeIf(x->x.getId().equals(id));
            facultyProfileRepo.save(facultyProfil);
            partA_0Repo.deleteById(id);
            return ResponseEntity.noContent().build();

    }

}
