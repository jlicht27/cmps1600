/* Declare your point3D struct here */
typedef struct point3D {
   int x;
   int y;
   int z;
} point3D;


/* Declare the move function header here */
void move(point3D* point, int deltaX, int deltaY, int deltaZ);
