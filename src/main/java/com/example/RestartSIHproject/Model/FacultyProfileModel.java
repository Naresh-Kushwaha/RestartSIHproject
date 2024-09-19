package com.example.RestartSIHproject.Model;


import com.example.RestartSIHproject.Utility.Lectures;
import com.example.RestartSIHproject.Utility.Result;
import com.example.RestartSIHproject.Utility.StudentAttendence;
import com.example.RestartSIHproject.Utility.partA_0;
import com.mongodb.lang.NonNull;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "FacultyProfile")

public class FacultyProfileModel {
    @Id
    private ObjectId id;
    @Indexed(unique=true)
    @NonNull
    private String username;
    private String password;
    private String email;
    private int otp;
    private Boolean verified=false;
    private String institution;
    private String googleScholarId;
    private String staffType;
    private String program;
    private String branch;
    private String course;
    private String designationType;
    private String image;

    @DBRef
    private partA_0 PartA_0;
    @DBRef
    private ArrayList<Lectures>PerformanceOfEngagingLectures=new ArrayList<>();
    @DBRef
    private ArrayList<StudentAttendence>PerformanceOfStudentAttendence=new ArrayList<>();
    @DBRef
    private ArrayList<Result>PerformanceOfResult=new ArrayList<>();

    public ArrayList<Result> getPerformanceOfResult() {
        return PerformanceOfResult;
    }


    public void setPerformanceOfResult(ArrayList<Result> performanceOfResult) {
        PerformanceOfResult = performanceOfResult;
    }

    public partA_0 getPartA_0() {
        return PartA_0;
    }

    public void setPartA_0(partA_0 partA_0) {
        PartA_0 = partA_0;
    }

    public ArrayList<Lectures> getPerformanceOfEngagingLectures() {
        return PerformanceOfEngagingLectures;
    }

    public void setPerformanceOfEngagingLectures(ArrayList<Lectures> performanceOfEngagingLectures) {
        PerformanceOfEngagingLectures = performanceOfEngagingLectures;
    }

    public ArrayList<StudentAttendence> getPerformanceOfStudentAttendence() {
        return PerformanceOfStudentAttendence;
    }

    public void setPerformanceOfStudentAttendence(ArrayList<StudentAttendence> performanceOfStudentAttendence) {
        PerformanceOfStudentAttendence = performanceOfStudentAttendence;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    @NonNull
    public String getUsername() {
        return username;
    }

    public void setUsername(@NonNull String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getOtp() {
        return otp;
    }

    public void setOtp(int otp) {
        this.otp = otp;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getStaffType() {
        return staffType;
    }

    public void setStaffType(String staffType) {
        this.staffType = staffType;
    }

    public String getGoogleScholarId() {
        return googleScholarId;
    }

    public void setGoogleScholarId(String googleScholarId) {
        this.googleScholarId = googleScholarId;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getDesignationType() {
        return designationType;
    }

    public void setDesignationType(String designationType) {
        this.designationType = designationType;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
