#include "point3D.h"
#include <stdio.h>

/* Implement the move function here */
void move(point3D* point, int deltaX, int deltaY, int deltaZ) {
   point->x += deltaX;
   point->y += deltaY;
   point->z += deltaZ;
}


int main(int argc, char *argv[]) {
   point3D origin = {0, 0, 0};
   printf("origin: (%d, %d, %d)\n", origin.x, origin.y, origin.z);
   move(&origin, 1, 1, 1);
   printf("origin: (%d, %d, %d)\n", origin.x, origin.y, origin.z);
   return 0;
}
