package model.isA.tpc;

public class SuperUser extends User {
    private String createUser;

    public SuperUser() {
    }

    public SuperUser(int userId, String userName, String userEmail, String createUser) {
        super(userId, userName, userEmail);
        this.createUser = createUser;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }
}
