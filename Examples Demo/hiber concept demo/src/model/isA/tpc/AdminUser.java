package model.isA.tpc;

public class AdminUser extends User {

    private String assinedJob;

    public AdminUser() {
    }

    public AdminUser(String userName, String userEmail, String assinedJob) {
        super(userName, userEmail);
        this.assinedJob = assinedJob;
    }

    public AdminUser(int userId, String userName, String userEmail, String assinedJob) {
        super(userId, userName, userEmail);
        this.assinedJob = assinedJob;
    }

    public String getAssinedJob() {
        return assinedJob;
    }

    public void setAssinedJob(String assinedJob) {
        this.assinedJob = assinedJob;
    }
}
