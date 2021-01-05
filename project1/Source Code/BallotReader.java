
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

/**
* This class reads information from an input file and creates a ballot from
* that information
*/
public class BallotReader{

	/**
	* Reads the information of the ballot and the candidates on the ballot
	* from a correctly formatted file
	* @param filename the file that the method should read from
	* @return a ballot that can be used to cast votes
	*/
	public static Ballot readBallot(String filename) throws IOException{

		String line = "";
		String name = "";
		String affiliation = "";

		//creates a file and a scanner to read the file
		File file = new File(filename);
		Scanner scnr = new Scanner(file);

		//an array that will hold the name and the affiliation of the candidate
    String[] information = new String[2];

		//reading first 2 lines of file
    String officeName = scnr.nextLine();
    int numOfCandidates = scnr.nextInt();
    String dummyVariable = scnr.nextLine();

		//creates ballot to return
		Ballot ballot = new Ballot(officeName);

		//loop through rest of lines of file
		//assigns the information in the lines to name and
		//affiliation of candidate in the ballot
    for (int i = 0; i < numOfCandidates; i++) {
			line = scnr.nextLine();
      information = line.split(";",2);
      name = information[0];
      affiliation = information[1];

      ballot.addCandidate(new Candidate(name,affiliation));
		}
		return ballot;
	}
}
