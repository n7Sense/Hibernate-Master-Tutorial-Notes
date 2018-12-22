package model.hasA.oto;

public class Vote {

    private int voteId;
    private String partyName;
    private Voter voter;

    public Vote() {
    }

    public Vote(int voteId, String partyName, Voter voter) {
        this.voteId = voteId;
        this.partyName = partyName;
        this.voter = voter;
    }

    public int getVoteId() {
        return voteId;
    }

    public void setVoteId(int voteId) {
        this.voteId = voteId;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public Voter getVoter() {
        return voter;
    }

    public void setVoter(Voter voter) {
        this.voter = voter;
    }
}
