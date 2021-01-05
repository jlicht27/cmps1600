#include <stdio.h>
#include <string.h>

void IntegerToReverseBinary(int integerValue, char binaryValue[]) {

   int index = 0;
   while (integerValue > 0 ) {
      if (integerValue%2 == 0) {
         binaryValue[index] = '0';
      }
      else {
         binaryValue[index] = '1';
      }
      index += 1;
      integerValue = integerValue/2;
   }
}

void ReverseString(char inputString[], char reversedString[]) {
   int i = 0;

   for (int j = strlen(inputString) - 1; j >= 0; j--) {
      reversedString[i] = inputString[j];
      i++;
   }
}

int main(void) {

   int userNum;
   char tempResult[50];
   char binaryString[50];

   printf("Input a number: ");
   scanf("%d", &userNum);

   IntegerToReverseBinary(userNum, tempResult);
   ReverseString(tempResult, binaryString);

   printf("Here is the number in binary: %s\n", binaryString);

   return 0;
}
