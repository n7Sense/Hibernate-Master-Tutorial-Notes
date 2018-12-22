package model.isA.tpsc;

public class Programmer extends Manager {

    private int progId;
    private String programming;
    private String technology;

    public Programmer() {}

    public Programmer(String managerName, String managerEmail, String programming, String technology) {
        super(managerName, managerEmail);
        this.programming = programming;
        this.technology = technology;
    }

    public int getProgId() {
        return progId;
    }

    public void setProgId(int progId) {
        this.progId = progId;
    }

    public String getProgramming() {
        return programming;
    }

    public void setProgramming(String programming) {
        this.programming = programming;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }
}
