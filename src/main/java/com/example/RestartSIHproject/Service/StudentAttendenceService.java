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

import java.util.Optional;

@Service
public class StudentAttendenceService {

    @Autowired
    private FacultyProfileRepo facultyProfileRepo;
    @Autowired
    private StudentAttendenceRepo studentAttendenceRepo;

    public ResponseEntity<?>AddStudentAttendence( StudentAttendence studentAttendence,String username){
        Optional<FacultyProfileModel> facultyProfileModel=facultyProfileRepo.findByUsername(username);
        if(facultyProfileModel.isPresent()){
            FacultyProfileModel facultyProfile= facultyProfileModel.get();
            studentAttendenceRepo.save(studentAttendence);
            studentAttendence.setAverageAttendence( (studentAttendence.getStudentPresent() * 100) /(studentAttendence.getLectureEngaged()*studentAttendence.getStudentRoll()));
            facultyProfile.getPerformanceOfStudentAttendence().add(studentAttendence);
            studentAttendenceRepo.save(studentAttendence);
            facultyProfileRepo.save(facultyProfile);
            return ResponseEntity.ok().build();


        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    public ResponseEntity<?>DeleteStudentAttendence(ObjectId id, String username){
        Optional<FacultyProfileModel> facultyProfileModel=facultyProfileRepo.findByUsername(username);
        if(facultyProfileModel.isPresent()){
            FacultyProfileModel facultyProfile= facultyProfileModel.get();
            studentAttendenceRepo.deleteById(id);
            facultyProfile.getPerformanceOfStudentAttendence().removeIf(x->x.getId().equals(id));
            facultyProfileRepo.save(facultyProfile);
            return ResponseEntity.ok().build();


        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

}
