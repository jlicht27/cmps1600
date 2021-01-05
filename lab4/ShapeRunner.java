import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;

public class ShapeRunner {
   public static void main(String[] args) {
      Scanner scr = new Scanner(System.in);
      
      ArrayList<Shape> shapes = new ArrayList<Shape>();
      
      while(true) {
         // -1 quit, 1 circle, 2 rectangle, 3 square
         int choice = scr.nextInt();
         if(choice == -1) {
            break;
         } else if (choice == 1) {
            double radius = scr.nextDouble();
            shapes.add(new Circle(radius));
            /* instantiate and add a circle to shapes ArrayList here. */
            
         } else if (choice == 2) {
            double length = scr.nextDouble();
            double width = scr.nextDouble();
            shapes.add(new Rectangle(length, width));
            /* instantiate and add a rectangle to shapes ArrayList here. */
            
         } else if (choice == 3) {
            double length = scr.nextDouble();
            shapes.add(new Square(length));
            /* instantiate and add a square to shapes ArrayList here. */
            
         }
      }
      Collections.sort(shapes);
      for(Shape shape : shapes) {
         System.out.println(shape);
      }
      /* Sort shapes and print out every shape here. */
      
   }
}