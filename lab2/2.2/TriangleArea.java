import java.util.Scanner;

public class TriangleArea {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);

      Triangle triangle1 = new Triangle();
      Triangle triangle2 = new Triangle();

      double userBase, userHeight;

      userBase = scnr.nextDouble();
      userHeight = scnr.nextDouble();
      triangle1.setBase(userBase);
      triangle1.setHeight(userHeight);

      userBase = scnr.nextDouble();
      userHeight = scnr.nextDouble();
      triangle2.setBase(userBase);
      triangle2.setHeight(userHeight);

      System.out.println("Triangle with larger area:");

      if (triangle1.getArea() > triangle2.getArea()) {
         triangle1.printInfo();
      }
      else {
         triangle2.printInfo();
      }
      
   }
}
