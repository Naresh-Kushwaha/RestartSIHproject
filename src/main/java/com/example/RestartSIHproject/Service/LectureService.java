package com.example.RestartSIHproject.Service;


import com.example.RestartSIHproject.Model.FacultyProfileModel;
import com.example.RestartSIHproject.Repository.FacultyProfileRepo;
import com.example.RestartSIHproject.Repository.LecturesRepo;
import com.example.RestartSIHproject.Utility.Lectures;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.objenesis.ObjenesisException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class LectureService {
    @Autowired
    private LecturesRepo lecturesRepo;
    @Autowired
    private FacultyProfileRepo facultyProfileRepo;

    private FacultyProfileModel getaFacultyProfileByUsername(String username){
        return facultyProfileRepo.findByUsername(username).orElseThrow(()->new IllegalArgumentException("faculty not found"));
    }
    @Transactional
    public ResponseEntity<?> AddLecture(Lectures lectures,String username){
             FacultyProfileModel facultyProfile=getaFacultyProfileByUsername(username);
        lectures.setTargetAchieved(lectures.getPeriodEngaged()/ lectures.getPeriodsAllotted());
            Lectures lectures1=lecturesRepo.save(lectures);
            facultyProfile.getPerformanceOfEngagingLectures().add(lectures);
            facultyProfileRepo.save(facultyProfile);
            return  ResponseEntity.ok().body(facultyProfile.getPerformanceOfEngagingLectures());

    }
    public ResponseEntity<ArrayList<Lectures>> getAllLecture(String username){

        FacultyProfileModel facultyProfile=getaFacultyProfileByUsername(username);
        return ResponseEntity.ok(facultyProfile.getPerformanceOfEngagingLectures());

    }
    @Transactional
    public ResponseEntity<?> DeleteLecture(ObjectId id, String username){
        FacultyProfileModel facultyProfie=getaFacultyProfileByUsername(username);
            lecturesRepo.deleteById(id);
            facultyProfie.getPerformanceOfEngagingLectures().removeIf(x->x.getId().equals(id));
            facultyProfileRepo.save(facultyProfie);
            return ResponseEntity.noContent().build();



    }

}
