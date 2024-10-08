package com.example.RestartSIHproject.Service;
import com.example.RestartSIHproject.Model.FacultyProfileModel;
import com.example.RestartSIHproject.Repository.FacultyProfileRepo;
import com.example.RestartSIHproject.Repository.LecturesRepo;
import com.example.RestartSIHproject.Repository.partA_0Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class FacultyProfileService {
    @Autowired
    private FacultyProfileRepo facultyProfileRepo;
    @Autowired
    private partA_0Repo  partA_0Repo;
    @Autowired
    private LecturesRepo lecturesRepo;

    public ResponseEntity<?> createProfile(FacultyProfileModel facultyProfileModel){
       return ResponseEntity.status(200).body(facultyProfileRepo.save(facultyProfileModel));
    }
    public FacultyProfileModel getFaculty(String username){
        FacultyProfileModel facultyProfile=facultyProfileRepo.findByUsername(username).get();
        return facultyProfile;
    }
    public ResponseEntity<?>setImage(String image,String usename){
        Optional<FacultyProfileModel> faculty=facultyProfileRepo.findByUsername(usename);
        if(faculty.isPresent()){
            FacultyProfileModel facultyProfile= faculty.get();
            facultyProfile.setImage(image);
            facultyProfileRepo.save(facultyProfile);
            return  ResponseEntity.ok().build();
        }
        else {
            return (ResponseEntity<?>) ResponseEntity.notFound();
        }

    }


    public ResponseEntity<?>updateProfile(FacultyProfileModel facultyProfileModel,String username){
        Optional<FacultyProfileModel> faculty=facultyProfileRepo.findByUsername(username);
        if(faculty!=null){
            FacultyProfileModel facultyProfile=faculty.get();
            facultyProfile.setEmail(facultyProfileModel.getEmail());
            facultyProfile.setInstitution(facultyProfileModel.getInstitution());
            facultyProfile.setGoogleScholarId(facultyProfileModel.getGoogleScholarId());
            facultyProfile.setStaffType(facultyProfileModel.getStaffType());
            facultyProfile.setProgram(facultyProfileModel.getProgram());
            facultyProfile.setBranch(facultyProfileModel.getBranch());
            facultyProfile.setCourse(facultyProfileModel.getCourse());
            facultyProfile.setDesignationType(facultyProfileModel.getDesignationType());
            facultyProfileRepo.save(facultyProfile);
            return ResponseEntity.ok("Faculty Data Updated");
        }
        else {
            return (ResponseEntity<?>) ResponseEntity.notFound();
        }


    }


    public List<FacultyProfileModel> getAllFaculty() {
        return facultyProfileRepo.findAll();
    }
}
