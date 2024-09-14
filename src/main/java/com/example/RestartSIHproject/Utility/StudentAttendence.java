package com.example.RestartSIHproject.Utility;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class StudentAttendence {
    @Id
    private ObjectId id;
    private int semester;
    private String course;
    private int studentPresent;
    private  int lectureEngaged;
    private int studentRoll;
    private float averageAttendence;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getStudentPresent() {
        return studentPresent;
    }

    public void setStudentPresent(int studentPresent) {
        this.studentPresent = studentPresent;
    }

    public int getLectureEngaged() {
        return lectureEngaged;
    }

    public void setLectureEngaged(int lectureEngaged) {
        this.lectureEngaged = lectureEngaged;
    }

    public int getStudentRoll() {
        return studentRoll;
    }

    public void setStudentRoll(int studentRoll) {
        this.studentRoll = studentRoll;
    }

    public float getAverageAttendence() {
        return averageAttendence;
    }

    public void setAverageAttendence(float averageAttendence) {
        this.averageAttendence = averageAttendence;
    }
}
