#include "point.h"
#include <cstdio>

/* Implement Point constructor here */
Point::Point(int X, int Y, int Z) {
   this->x = X;
   this->y = Y;
   this->z = Z;
}

/* Implement move() here */
void Point::move(int deltaX, int deltaY, int deltaZ) {
   this->x += deltaX;
   this->y += deltaY;
   this->z += deltaZ;
}

/* Implement getX() here */
int Point::getX() {
   return this->x;
}


/* Implement getY() here */
int Point::getY() {
   return this->y;
}

/* Implement getZ() here */
int Point::getZ() {
   return this->z;
}

int main(int argc, char *argv[]) {
   Point origin(0, 0, 0);
   printf("origin: (%d, %d, %d)\n", origin.getX(), origin.getY(), origin.getZ());
   origin.move(1, 2, 3);
   printf("origin: (%d, %d, %d)\n", origin.getX(), origin.getY(), origin.getZ());
   return 0;
}
