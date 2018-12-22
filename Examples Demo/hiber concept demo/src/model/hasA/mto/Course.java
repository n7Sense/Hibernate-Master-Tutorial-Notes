package model.hasA.mto;

public class Course {

    private int courseId;
    private String courseName;
    Faculty faculty;
    public Course() {
    }

    public Course(int courseId, String courseName, Faculty faculty) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.faculty = faculty;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
}
