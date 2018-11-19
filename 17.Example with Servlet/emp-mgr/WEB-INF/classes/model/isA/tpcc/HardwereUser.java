package model.isA.tpcc;

public class HardwereUser extends TPCCUser {

    private String hardwereUser;

    public HardwereUser() {
    }

    public HardwereUser(int userId, String userName, String userEmail, String hardwereUser) {
        super(userId, userName, userEmail);
        this.hardwereUser = hardwereUser;
    }
    
    public String getHardwereUser() {
        return hardwereUser;
    }

    public void setHardwereUser(String hardwereUser) {
        this.hardwereUser = hardwereUser;
    }
}
