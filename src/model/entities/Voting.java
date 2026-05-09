package model.entities;

public class Voting {
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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((candidate == null) ? 0 : candidate.hashCode());
        result = prime * result + ((votes == null) ? 0 : votes.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Voting other = (Voting) obj;
        if (candidate == null) {
            if (other.candidate != null)
                return false;
        } else if (!candidate.equals(other.candidate))
            return false;
        if (votes == null) {
            if (other.votes != null)
                return false;
        } else if (!votes.equals(other.votes))
            return false;
        return true;
    }

    
}
