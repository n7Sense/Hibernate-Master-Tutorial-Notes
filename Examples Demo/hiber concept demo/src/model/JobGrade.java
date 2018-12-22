package model;

public class JobGrade {
    private String grade;
    private int lowestSal;
    private int highestSal;

    public JobGrade() {
    }

    public JobGrade(String grade, int lowestSal, int highestSal) {
        this.grade = grade;
        this.lowestSal = lowestSal;
        this.highestSal = highestSal;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getLowestSal() {
        return lowestSal;
    }

    public void setLowestSal(int lowestSal) {
        this.lowestSal = lowestSal;
    }

    public int getHighestSal() {
        return highestSal;
    }

    public void setHighestSal(int highestSal) {
        this.highestSal = highestSal;
    }
}
