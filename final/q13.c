#include <stdio.h>


int main() {
  int q = 72;
  int* p;
  // missing line
  p = &q;
  printf("%d\n", *p); // prints 72
}
