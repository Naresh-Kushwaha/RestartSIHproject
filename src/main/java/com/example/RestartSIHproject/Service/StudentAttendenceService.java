package com.example.RestartSIHproject.Service;


import com.example.RestartSIHproject.Model.FacultyProfileModel;
import com.example.RestartSIHproject.Repository.FacultyProfileRepo;
import com.example.RestartSIHproject.Repository.StudentAttendenceRepo;
import com.example.RestartSIHproject.Utility.StudentAttendence;
import org.apache.coyote.Response;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class StudentAttendenceService {

    @Autowired
    private FacultyProfileRepo facultyProfileRepo;
    @Autowired
    private StudentAttendenceRepo studentAttendenceRepo;

    private FacultyProfileModel getFacultyProfileByUsername(String username){
        return facultyProfileRepo.findByUsername(username).orElseThrow(()->new IllegalArgumentException("faculty not found"));
    }
    @Transactional
    public ResponseEntity<?>AddStudentAttendence( StudentAttendence studentAttendence,String username){
    FacultyProfileModel facultyProfile =getFacultyProfileByUsername(username);
            studentAttendenceRepo.save(studentAttendence);
            studentAttendence.setAverageAttendence( (float) (studentAttendence.getStudentPresent() * 100) /(studentAttendence.getLectureEngaged()*studentAttendence.getStudentRoll()));
            facultyProfile.getPerformanceOfStudentAttendence().add(studentAttendence);
            studentAttendenceRepo.save(studentAttendence);
            facultyProfileRepo.save(facultyProfile);
            return ResponseEntity.ok().build();

    }
    @Transactional
    public ResponseEntity<?>DeleteStudentAttendence(ObjectId id, String username){
        FacultyProfileModel facultyProfile =getFacultyProfileByUsername(username);
            studentAttendenceRepo.deleteById(id);
            facultyProfile.getPerformanceOfStudentAttendence().removeIf(x->x.getId().equals(id));
            facultyProfileRepo.save(facultyProfile);
            return ResponseEntity.ok().build();

    }

}
