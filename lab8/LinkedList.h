#include <stdbool.h>


typedef struct node_struct {
  /* Define the Node attributes here */
  int element;
  struct node_struct* next;
} Node;

typedef struct linkedList_struct {
  /* Define the LinkedList attributes here */
  Node* head;
  Node* tail;
  int size;
} LinkedList;

/*
 * Return true if the list is empty, false otherwise.
*/
bool isEmpty(LinkedList *list);

/*
 * Add element to the end of the LinkedList.
*/
void add(LinkedList *list, int element);

/*
 * Remove the head node from the LinkedList.
*/
void removeHead(LinkedList *list);

/*
 * Return a string representation of a single node. If a node has
 * a next node, the string includes the arrow " -> ".
*/
char* nodeToString(Node *node);

/*
 * Return a string representing the linked list starting
 * at node head.
*/
char* listToString(LinkedList *list);

/*
 * Print the string representation of this list as returned by
 * listToString.
*/
void printList(LinkedList *list);
