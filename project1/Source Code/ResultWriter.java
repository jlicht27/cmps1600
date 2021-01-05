
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;

/**
* This class writes the results from the ballot to a file
*/
public class ResultWriter{
	/**
	* Writes the results of the ballot to a file
	* @param filename the file the writer will writer to
	* @param ballot the ballot that the writer will write
	*/
	public static void writeResults(String filename, Ballot ballot) throws IOException{

		//creates a writer to write to file
    FileWriter writer = new FileWriter(filename);

		//actually writing to file
    writer.write(ballot.toString());

		//closing file
    writer.close();
	}
}
