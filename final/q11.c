#include <stdio.h>

int foo(char* s)
{
  int i = 0;
  while(*(s+i) != '\0') {
    i++;
  }
  return i;
}

int main() {
  char* str = "This tests the length of the string";
  printf("%d\n", foo(str));
  return 0;
}
