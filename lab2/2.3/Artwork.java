public class Artwork {
   // TODO: Declare private fields - title, yearCreated
   
   private String title;
   private int yearCreated;
      
   // TODO: Declare private field artist of type Artist 
   
   private Artist artist;
   
   // TODO: Define default constructor
   
   Artwork() {
      title = "None";
      yearCreated = 0;
      artist = new Artist();
   }
   
   Artwork(String userTitle, int userYearCreated, Artist userNewArtist) {
      title = userTitle;
      yearCreated = userYearCreated;
      artist = userNewArtist;
   }
   
   // TODO: Define get methods: getTitle(), getYearCreated()
   
   public String getTitle() {
      return title;
   }
   
   public int getYearCreated() {
      return yearCreated;
   }
   
   public Artist getArtist() {
      return artist;
   }

   // TODO: Define second constructor to initialize 
   //       private fields (title, yearCreated, artist)
   
   public void printInfo() {
      artist.printInfo();
      System.out.println("Title: " + title + ", " + yearCreated);
   }

   // TODO: Define printInfo() method                                                                                             

}
