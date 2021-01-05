#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include "LinkedList.c"

int main(int argc, char *argv[]) {
  LinkedList *list = (LinkedList*)malloc(sizeof(LinkedList));
  // build a list containing 3, 5, 7, 11
  add(list, 3);
  printList(list);
  add(list, 5);
  printList(list);
  add(list, 7);
  printList(list);
  add(list, 11);
  printList(list);
  // Remove elements one at a time
  int size = list->size;
  for(int i = 0; i < size; i++) {
    removeHead(list);
    printList(list);
  }
  free(list);
}
