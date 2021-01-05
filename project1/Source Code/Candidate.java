/**
* This class is a candidate that the user will vote for in a Ballot
*/
public class Candidate{

	/**
	* Name of the candidate
	*/
	private String name;

	/**
	* Affiliation of the candidate
	*/
	private String affiliation;

	/**
	* Number of votes the candidate has recieved
	*/
	private int votes = 0;

	/**
	* Create a candidate
	* @param name of the candidate
	* @param affiliation of the candidate
	*/
	public Candidate(String name, String affiliation) {
		this.name = name;
		this.affiliation = affiliation;
	}

	/**
	* Returns the name of the candidate
	* @return the name of the candidate
	*/
	public String getName(){
    return this.name;
	}

	/**
	* Returns the affiliation of the candidate
	* @return the affiliation of the candidate
	*/
	public String getAffiliation(){
    return this.affiliation;

	}

	/**
	* Returns the number of votes a candidate has
	* @return the current nunber of votes a candidate has recieved
	*/
	public int getVoteCount(){
    return this.votes;
	}

	/**
	* Increment the number of votes for a candidate by one
	*/
	public void tallyVote(){
		this.votes += 1;
	}

	/**
	* Returns the "tag" of the candidate, which is simply the name and affiliation
	* of the candidate
	* @return the name and affiliation of candidate with a dash in between them
	*/
	public String toString(){
    return this.name + " - " + this.affiliation;
	}

	/**
	* Compares the number of votes between two candidates
	* Returns a postive number if the first candidate has more votes, zero if
	* the two candidates have an equal number of votes, and a negative number if
	* the second candidate has more votes
	* @return the difference between the number of votes of the first candidate
	* and the second candidate
	*/
	public int compareNumVotes(Candidate other){
		return this.getVoteCount() - other.getVoteCount();
	}
}
