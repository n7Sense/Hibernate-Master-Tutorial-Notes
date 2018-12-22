package model.isA.tpc;

public class SuperUser extends User {
    private String createUser;

    public SuperUser() {
    }

    public SuperUser(String userName, String userEmail, String createUser) {
        super(userName, userEmail);
        this.createUser = createUser;
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

    @Override
    public String toString() {
        return "SuperUser{" +
                "createUser='" + createUser + '\'' +
                '}';
    }
}
