package com.example.RestartSIHproject.Utility;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Result {
    @Id
    private ObjectId id;
    private int semester;
    private String course;
    private float averageResult;

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

    public float getAverageResult() {
        return averageResult;
    }

    public void setAverageResult(float averageResult) {
        this.averageResult = averageResult;
    }
}
