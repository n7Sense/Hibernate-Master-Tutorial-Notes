package model.isA.tpsc;

public class Programmer extends PPRUser {


    private String programming;

    public Programmer() {}

    public Programmer(int userId, String userName, String userEmail, String programming) {
        super(userId, userName, userEmail);
        this.programming = programming;
    }
    
    public String getProgramming() {
        return programming;
    }

    public void setProgramming(String programming) {
        this.programming = programming;
    }
}
