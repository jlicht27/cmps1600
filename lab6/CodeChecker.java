//import libraries
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

/**
* CodeChecker can be used to detect mismatched parentheses (), curly braces {},
* or square brackets [] in a source file read in from the user.
* <br>
* Usage: {@code java CodeChecker /path/to/source.java}
*/
public class CodeChecker {

	public static void main(String[] args) {
      
	}
	
	/**
    * Run the mismatched brackets checkers on a file specified by fileName.
    * @param fileName the name of the file to read int
   */
	public static void runBracketsChecker(String fileName) {
	   try {
         ArrayList<String> lines = readInFile(fileName);
         
         boolean mismatched = containsMismatchedBrackets(lines);
         if(mismatched) {
            System.out.printf("%s contains mismatched brackets.\n", fileName);
         }
      } catch(IOException e) {
         System.out.printf("File \"%s\" not found.\n", fileName);
         System.out.println("Ensure that you have specified a valid file name as input for this program.");
      }
	}

   /**
    * Read in a file, returning an ArrayList<String> containing all lines in that file.
    * @param fileName the name of the file to read int
    * @return an ArrayList<String> containing all lines in this file
    * @throws IOException if the file can not be opened or closed
   */
   public static ArrayList<String> readInFile(String fileName) throws IOException {
      // Stubbed. Implement this method.
      
      FileInputStream file = new FileInputStream(fileName);
      Scanner in = new Scanner(file);
      ArrayList<String> lines = new ArrayList<String>();
      while(in.hasNextLine()) {
         lines.add(in.nextLine());
      }
      file.close();
      return lines;
   }

   /**
   * Return true if the list of lines contains mismatched parentheses (),
   * curly braces {}, or square brackets [].
   * <br>
   * This method also prints out error messages to std out if
   * mismatched brackets are discovered.
   * @param lines the list of lines
   * @return true if thae lines contain mismatched brackets, false
   * otherwise
   */
   public static boolean containsMismatchedBrackets(List<String> lines) {
      // Stubbed. Implement this method.
      
      Stack<String> s = new Stack<String>();
      String character;
      for (String line : lines) {
         for (int i = 0; i < line.length(); i++) {
            character = String.valueOf(line.charAt(i));
            if (character.equals("{") || character.equals("(") || character.equals("[")) {
               s.push(character);
            }
            
            if (s.isEmpty() && (character.equals("}") || character.equals(")") || character.equals("]"))){
               System.out.printf("Error. Stack empty, no opening bracket to match closing %s.\n", character);
               return true;
            }
            
            
            //repeat block
            if (character.equals("]")) {
               String c = s.pop();
               if (!c.equals("[")) {
                  System.out.printf("Error. Closing ] encountered. Does not match %s popped off the stack.\n", c);
                  return true;
               }
            }
            if (character.equals("}")) {
               String c = s.pop();
               if (!c.equals("{")) {
                  System.out.printf("Error. Closing } encountered. Does not match %s popped off the stack.\n", c);
                  return true;
               }
            }
            
            if (character.equals(")")) {
               String c = s.pop();
               if (!c.equals("(")) {
                  System.out.printf("Error. Closing ) encountered. Does not match %s popped off the stack.\n", c);
                  return true;
               }
            }
         }
      }
      
      if (!s.isEmpty()) {
         System.out.printf("Error. One or more opening brackets never closed. Closing %s is still on the stack.\n", s.peek());
         return true;
      }
      else {
         System.out.println("All brackets are balanced.");
         return false;
      }
   }
}