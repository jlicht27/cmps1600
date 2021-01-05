public abstract class Shape implements Comparable<Shape> {
   
   private static int shapeCount = 0;
  
   public Shape() {
      shapeCount++;
   }
  
   public static int getShapeCount() {
      return shapeCount;
   }
  
   public abstract double area();
  
   public abstract double perimeter();
  
   public abstract String getShapeName();
  
   @Override
   public int compareTo(Shape other) {
      double diff = this.area() - other.area();
         if (Math.abs (diff) < 0.0000001) {
            return 0;
      }
      else if (diff < 0) {
         return -1;
      }
      else {
         return 1;
      }
   }
   @Override
   public String toString() {
      return String.format("%s\nArea: %.2f\nPerimeter: %.2f\n", getShapeName(), area(), perimeter());
   }
     
     
}