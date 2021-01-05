public class Encyclopedia extends Book {
   // TODO: Declare private fields: edition, numVolumes
   private String edition;
   private int numVolumes;
  
   
   // TODO: Define mutator methods - 
   //       setEdition(), setNumVolumes()
   public void setEdition(String userEdition) {
      edition = userEdition;
   }
   
   public void setNumVolumes(int userNumVolumes) {
      numVolumes = userNumVolumes;
   }
   
  
   // TODO: Define accessor methods -
   //       getEdition(), getNumVolumes()
   
   public String getEdition () {
      return edition;
   }
   
   public int getNumVolumes () {
      return numVolumes;
   }
   
   
   // TODO: Define a printInfo() method that overrides 
   //       the printInfo in Book class 
   
   @Override
   public void printInfo() {
      super.printInfo();
      System.out.println("   Edition: " + edition);
      System.out.println("   Number of Volumes: " + numVolumes);
   }
}