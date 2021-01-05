/* Define class Point here */
class Point {

   int x;
   int y;
   int z;
   
   public:
      Point(int X, int Y, int Z);

      void move(int deltaX, int deltaY, int deltaZ);

      int getX();

      int getY();

      int getZ();
};
