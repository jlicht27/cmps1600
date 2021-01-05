
import java.util.ArrayList;
/**
* This class is a ballot in which the user votes for candidates for an
* award/issue
*/
public class Ballot{

  /**
  * A list of all the candidates
  */
  private ArrayList<Candidate> candidates;

  /**
  * The office the candidates are running for
  */
  private String officeName;

  /**
  * Create a Ballot
  * @param officeName office the candidates are running for
  */
	public Ballot(String officeName){
		this.officeName = officeName;
		candidates = new ArrayList<Candidate>();
	}

  /**
  * Returns the office name of the ballot
  * @return the office name of the ballot
  */
	public String getOfficeName(){
    return this.officeName;

	}

  /**
  * Add a candidate to a ballot
  * @param c the candidate to add
  */
	public void addCandidate(Candidate c){
		if (!candidates.contains(c)) {
			candidates.add(c);
		}
		else {
			System.out.println("Duplicate candidate");
		}
	}

  /**
  * Returns a list of candidates for the ballot
  * @return a list of candidates for the ballot
  */
	public ArrayList<Candidate> getCandidates(){
    return candidates;
	}

  /**
  * Returns a summary of the ballot which includes information about the
  * office the canidates are running for, the candidates included, and the
  * winner of the ballot
  * @return a string with all information about the ballot
  */
	public String toString(){

    //first two lines of output file
    String result = "RESULTS - " + this.getOfficeName() + "\n";
    result += "-".repeat(result.length() - 1) + "\n";

    //max number of characters in tag plus characters in vote count
    int max = 0;

    //max number of votes
    int maxNumVotes = 0;

    //candidate with most characters in tag plus characters in vote count
    String maxLenTag = "";

    //tracks which candidate tag plus num of digits in vote count is longest
    for (Candidate item : candidates) {
      if (item.toString().length() + Integer.toString(item.getVoteCount()).length() > max) {
        max = (item.toString() + Integer.toString(item.getVoteCount())).length();
        maxNumVotes = item.getVoteCount();
        maxLenTag = item.toString();
      }
    }

    //number of spaces for the longest tag
    int numSpacesForLongestTag = 12 - Integer.toString(maxNumVotes).length();

    //current number of characters in tag plus characters in vote count
    int currentLength = 0;

    //loop throught candidates and print each one
    for (Candidate c : candidates) {
      currentLength = (c.toString() + Integer.toString(c.getVoteCount())).length();
      result += c.toString();
      //if this tag is the longest tag, add a certain amount of spaces
      if (c.toString().equals(maxLenTag)) {
        for (int i = 0; i < numSpacesForLongestTag; i++) {
          result += " ";
        }
      }
      else {
        for (int j = 0; j < numSpacesForLongestTag + max - currentLength; j++) {
          result += " ";
        }
      }
      result += c.getVoteCount() + "\n";
    }

    int maxVotes = -1;
    String winner = "";
    boolean tie = false;
    //loop the number of votes and determine the winner if there is one
    for (Candidate c : candidates) {
      if (c.getVoteCount() > maxVotes) {
        winner = c.toString();
        maxVotes = c.getVoteCount();
        tie = false;
      }
      else if (c.getVoteCount() == maxVotes) {
        tie = true;
      }
    }

    //different output for if there is a winner or a tie
    if (tie == true) {
      result += "\nNO WINNER";
    }
    else {
      result += "\nWINNER: " + winner;
    }

    //returns the final string
    return result;
	}
}
