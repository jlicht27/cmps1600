#include <stdio.h>

int main(void) {

   int num;
   int i;
   char binaryNum[50];

   printf("Input a number: ");
   scanf("%d", &num);
   printf("Here is the number in binary but reverse order: ");
   while (num > 0 ) {
      printf("%d", num%2);
      num = num / 2;
   }

   printf("\n");



   return 0;
}
