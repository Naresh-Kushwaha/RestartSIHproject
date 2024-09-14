package com.example.RestartSIHproject.Utility;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Engaging Lectures")
public class Lectures {
    @Id
    private ObjectId id;
    private int semester;
    private String course;
    private Double periodsAllotted;
    private Double periodEngaged;
    private Double targetAchieved;

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

    public Double getPeriodsAllotted() {
        return periodsAllotted;
    }

    public void setPeriodsAllotted(Double periodsAllotted) {
        this.periodsAllotted = periodsAllotted;
    }

    public Double getPeriodEngaged() {
        return periodEngaged;
    }

    public void setPeriodEngaged(Double periodEngaged) {
        this.periodEngaged = periodEngaged;
    }

    public Double getTargetAchieved() {
        return targetAchieved;
    }

    public void setTargetAchieved(Double targetAchieved) {
        this.targetAchieved = targetAchieved;
    }
}
