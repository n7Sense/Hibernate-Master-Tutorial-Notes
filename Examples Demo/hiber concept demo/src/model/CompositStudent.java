package model;

import java.io.Serializable;

public class CompositStudent implements Serializable {

    private int studId;
    private int collegeId;
    private String deptId;
    String studName;
    String studCOurse;

    public CompositStudent() {

    }

    public int getStudId() {
        return studId;
    }

    public void setStudId(int studId) {
        this.studId = studId;
    }

    public int getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(int collegeId) {
        this.collegeId = collegeId;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getStudName() {
        return studName;
    }

    public void setStudName(String studName) {
        this.studName = studName;
    }

    public String getStudCOurse() {
        return studCOurse;
    }

    public void setStudCOurse(String studCOurse) {
        this.studCOurse = studCOurse;
    }
}
