public class Artist {
   
   // TODO: Declare private fields - artistName, birthYear, deathYear
   
   private String artistName;
   private int birthYear;
   private int deathYear;
   
   // TODO: Define default constructor
   
   Artist() {
      artistName = "None";
      birthYear = 0;
      deathYear = 0;
   }
   // TODO: Define second constructor to initialize 
   //       private fields (artistName, birthYear, deathYear)
   
   Artist(String userArtistName, int userBirthYear, int userDeathYear) {
      artistName = userArtistName;
      birthYear = userBirthYear;
      deathYear = userDeathYear;
   }
   
   // TODO: Define get methods: getName(), getBirthYear(), getDeathYear()
   
   
   public String getName() {
      return artistName;
   }
      
   public int getBirthYear() {
      return birthYear;
   }
   
   public int getDeathYear() {
      return deathYear;
   }
   
   // TODO: Define printInfo() method
   //      If deathYear is entered as -1, only print birthYear

   public void printInfo() {
      if (deathYear == -1) {
         System.out.println("Artist: " + artistName + ", born " + birthYear);
      }
      else {
         System.out.println("Artist: " + artistName + " (" + birthYear + "-" + deathYear + ")");
      }
   }
}