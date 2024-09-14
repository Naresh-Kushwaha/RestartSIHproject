package com.example.RestartSIHproject.Controller;


import com.example.RestartSIHproject.Model.FacultyProfileModel;

import com.example.RestartSIHproject.Repository.FacultyProfileRepo;
import com.example.RestartSIHproject.Repository.StudentAttendenceRepo;
import com.example.RestartSIHproject.Service.*;
import com.example.RestartSIHproject.Utility.Lectures;
import com.example.RestartSIHproject.Utility.Result;
import com.example.RestartSIHproject.Utility.StudentAttendence;
import com.example.RestartSIHproject.Utility.partA_0;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class FacultyProfilecontroller {
    @Autowired
    private FacultyProfileService facultyProfileService;
    @Autowired
    private LectureService lectureService;
    @Autowired
    private partA_0Service partA_0Service;
    @Autowired
    private StudentAttendenceService studentAttendenceService;
    @Autowired
    private ResultService resultService;

    @Autowired
    private FacultyProfileRepo facultyProfileRepo;
    @PostMapping("/create")
    public ResponseEntity<?> CreateFacultyProfile(@RequestBody FacultyProfileModel facultyProfileModel){

        return  facultyProfileService.createProfile(facultyProfileModel);
    }
    @PutMapping("/update/{username}")
    public  ResponseEntity<?> UpdateProfile(@RequestBody FacultyProfileModel facultyProfileModel,@PathVariable String username){
        return  facultyProfileService.updateProfile(facultyProfileModel,username);
    }
    @PostMapping("/addpartA/{username}")
    public  ResponseEntity<?> AddPartA(@RequestBody partA_0 partA_0,@PathVariable String username){
       return partA_0Service.AddPartA_0(partA_0,username);
    }
    @PostMapping("/addlecture/{username}")
    public ResponseEntity<?> AddLecture(@RequestBody Lectures lectures,@PathVariable String username){
        return  lectureService.AddLecture(lectures,username);
    }
    @GetMapping("/get/{username}")
    public ArrayList<Lectures> get(@PathVariable String username){
       return   facultyProfileRepo.findByUsername(username).get().getPerformanceOfEngagingLectures();

    }
    @DeleteMapping("/deletelecture/{id}/{username}")
    public  ResponseEntity<?> DeleteLecture(@PathVariable ObjectId id,@PathVariable String username){
        return  lectureService.DeleteLecture(id,username);
    }
    @DeleteMapping("/deletepartA/{id}/{username}")
    public ResponseEntity<?>DeletePartA(@PathVariable ObjectId id,@PathVariable String username){
        return   partA_0Service.DeletePartA_0(id,username);

    }
    @PostMapping("addstudatt/{username}")
    public ResponseEntity<?> AddStudentAtt(@RequestBody StudentAttendence studentAttendence,@PathVariable String username){
        return studentAttendenceService.AddStudentAttendence(studentAttendence,username);
    }
    @DeleteMapping("deletestuatt/{id}/{username}")
    public ResponseEntity<?> DeleteStuAtt(@PathVariable ObjectId id,@PathVariable String username){
        return studentAttendenceService.DeleteStudentAttendence(id,username);

    }
    @PostMapping("addresult/{username}")
    public ResponseEntity<?> addResult(@RequestBody Result result ,@PathVariable String username){
        return resultService.addResult(result,username);
    }
    @DeleteMapping("deleteresult/{id}/{username}")
    public ResponseEntity<?> DeleteResult(@PathVariable ObjectId id,@PathVariable String username){
        return resultService.deleteResult(id,username);
    }


}
