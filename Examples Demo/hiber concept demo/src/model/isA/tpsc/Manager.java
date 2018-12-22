package model.isA.tpsc;

public class Manager {
    private int managerId;
    private String managerName;
    private String managerEmail;

    public Manager() {
    }

    public Manager(String managerName, String managerEmail) {
        this.managerName = managerName;
        this.managerEmail = managerEmail;
    }

    public Manager(int managerId, String managerName, String managerEmail) {
        this.managerId = managerId;
        this.managerName = managerName;
        this.managerEmail = managerEmail;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerEmail() {
        return managerEmail;
    }

    public void setManagerEmail(String managerEmail) {
        this.managerEmail = managerEmail;
    }
}
