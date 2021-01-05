#include <stdio.h>
#include <stdbool.h>

int length(char* s) {
  int i = 0;
  while(*(s+i) != '\0') {
    i++;
  }
  return i;
}

bool foo(char* s){

  char* a = s;
  int len = length(s); // implemented but not shown
  char* b = a + (len - 1);
  while(a < b) {
    if(*a != *b) {
      return false;
    }
    a++;
    b--;
  }
  return true;
}

int main() {
  char* str = "nursesrun";
  bool result = foo(str);
  if (result == true) {
    printf("1\n");
  }
  if (result == false) {
    printf("0\n");
  }
}
