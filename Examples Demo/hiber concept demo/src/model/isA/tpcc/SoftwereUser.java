package model.isA.tpcc;

public class SoftwereUser extends TPCCUser {

    private String softwereUser;

    public SoftwereUser() {
    }

    public SoftwereUser(int userId, String userName, String userEmail, String softwereUser) {
        super(userId, userName, userEmail);
        this.softwereUser = softwereUser;
    }
    
    public String getSoftwereUser() {
        return softwereUser;
    }

    public void setSoftwereUser(String softwereUser) {
        this.softwereUser = softwereUser;
    }
}
