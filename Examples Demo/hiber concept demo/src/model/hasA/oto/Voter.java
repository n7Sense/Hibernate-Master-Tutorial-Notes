package model.hasA.oto;

public class Voter {

    private int voterId;
    private String voterName;
    private int age;

    public Voter() {
    }

    public Voter(int voterId, String voterName, int age) {
        this.voterId = voterId;
        this.voterName = voterName;
        this.age = age;
    }

    public int getVoterId() {
        return voterId;
    }

    public void setVoterId(int voterId) {
        this.voterId = voterId;
    }

    public String getVoterName() {
        return voterName;
    }

    public void setVoterName(String voterName) {
        this.voterName = voterName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
