#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include "LinkedList.h"

/* Implement isEmpty() here. */
bool isEmpty(LinkedList* list){
   return list->size == 0;
}


/* Implement add() here. */
void add(LinkedList* list, int element){
   Node* node = (Node*)malloc(sizeof(Node));
   node->element = element;
   node->next = NULL;
   if (!isEmpty(list)) {
      list->tail->next = node;
      list->tail = node;
   }
   else {
      list->head = node;
      list->tail = node;
   }
   list->size++;
}

/* Implement removeHead() here. */
void removeHead(LinkedList* list){
   if (list->size <= 1) {
      free(list->head);
      list->head = NULL;
      list->tail = NULL;
      list->size = 0;
   }
   else {
      Node* head = list->head;
      list->head = list->head->next;
      free(head);
      list->size--;
   }
      
}

char* nodeToString(Node *node) {
  // dynamically allocate enough space for the largest string that
  // can be built. Since int range is -4 Billion to +4 Billion,
  // largest string is "[-4000000000] -> ", 17 characters + 1 for '\0'
  char* nodeStr = (char*)malloc(18*sizeof(char));
  // write to nodeStr the formatted string for this node's data
  sprintf(nodeStr, "[%d]", node->element);

  // if this node points to a next node, append the arrow
  if(node->next != NULL) {
    nodeStr = strcat(nodeStr, " -> ");
  }

  return nodeStr;
}

char* listToString(LinkedList *list) {
  // This function dynamically allocates space for the string as it builds it.
  char* listStr = (char*)malloc(3*sizeof(char));
  // if the list is empty, simple return "[]"
  if(list->size == 0) {
    strcpy(listStr, "[]");
    return listStr;
  }
  listStr[0] = '\0';
  Node *node = list->head;
  while(node != NULL) {
    // get the string representation of the current node.
    char *nodeStr = nodeToString(node);
    // Will need to expand the listStr's memory to make space for the next node.
    // Calculate the required length.
    int len = strlen(listStr) + strlen(nodeStr);
    // Use malloc to dynamically expand the allocated memory for the string.
    // malloc returns a pointer to the new memory
    char *newMem = (char*)malloc(len*sizeof(char));
    strcpy(newMem, listStr); // copy the contents of listStr into newMem
    free(listStr); // good memory menagement, free old listStr memory
    listStr = newMem; // reassign listStr pointer to point to copied string
    // concatenate the nodeStr to the end of listStr
    strcat(listStr, nodeStr);
    // now that nodeStr contents have been appended to listStr, free nodeStr
    free(nodeStr);
    // move to the next node
    node = node->next;
  }

  return listStr;
}

void printList(LinkedList *list) {
  char *listStr = listToString(list);
  printf("%s\nSize: %d\n", listStr, list->size);
  free(listStr);
}