package com.example.RestartSIHproject.Utility;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "PartA_0")
public class partA_0 {
@Id
private ObjectId id;
    private int academicYear;
    private String facultyname;
    private String post;
    private int payScale;
    private String institution;
    private int workingInThisInstitution;
    private String sectionalHead;
    private String institutionHead;
    private String departmentHead;
    private String secretary;

    public int getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(int academicYear) {
        this.academicYear = academicYear;
    }

    public String getFacultyname() {
        return facultyname;
    }

    public void setFacultyname(String facultyname) {
        this.facultyname = facultyname;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public int getPayScale() {
        return payScale;
    }

    public void setPayScale(int payScale) {
        this.payScale = payScale;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public int getWorkingInThisInstitution() {
        return workingInThisInstitution;
    }

    public void setWorkingInThisInstitution(int workingInThisInstitution) {
        this.workingInThisInstitution = workingInThisInstitution;
    }

    public String getSectionalHead() {
        return sectionalHead;
    }

    public void setSectionalHead(String sectionalHead) {
        this.sectionalHead = sectionalHead;
    }

    public String getInstitutionHead() {
        return institutionHead;
    }

    public void setInstitutionHead(String institutionHead) {
        this.institutionHead = institutionHead;
    }

    public String getDepartmentHead() {
        return departmentHead;
    }

    public void setDepartmentHead(String departmentHead) {
        this.departmentHead = departmentHead;
    }

    public String getSecretary() {
        return secretary;
    }

    public void setSecretary(String secretary) {
        this.secretary = secretary;
    }
}
