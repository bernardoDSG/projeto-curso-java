package model.entities;

public class Voting implements Comparable<Voting> {
    String candidate;
    Integer votes;

    

    public Voting(String candidate, Integer votes) {
        this.candidate = candidate;
        this.votes = votes;
    }

    public String getCandidate() {
        return candidate;
    }

    public void setCandidate(String candidate) {
        this.candidate = candidate;
    }

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    @Override
    public int compareTo(Voting vot) {
        return -votes.compareTo(vot.getVotes());
    }

}
