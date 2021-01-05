#include <iostream>
using namespace std;

#include "ItemToPurchase.cpp"

int main() {

   /* Type your code here */

   ItemToPurchase item1;
   ItemToPurchase item2;
   string itemName;
   int itemPrice;
   int itemQuantity;
   int totalCost;

   cout << "Item 1\n" << "Enter the item name:" << endl;
   getline(cin, itemName);
   cout << "Enter the item price:" << endl;
   cin >> itemPrice;
   cout << "Enter the item quantity:" << endl;
   cin >> itemQuantity;
   cout << endl;
   item1.SetName(itemName);
   item1.SetPrice(itemPrice);
   item1.SetQuantity(itemQuantity);

   cin.ignore();

   cout << "Item 2\n" << "Enter the item name:" << endl;
   getline(cin, itemName);
   cout << "Enter the item price:" << endl;
   cin >> itemPrice;
   cout << "Enter the item quantity:" << endl;
   cin >> itemQuantity;
   cout << endl;
   item2.SetName(itemName);
   item2.SetPrice(itemPrice);
   item2.SetQuantity(itemQuantity);


   cout << "TOTAL COST" << endl;
   cout << item1.GetName() << " " << item1.GetQuantity() << " @ $" <<
   item1.GetPrice() << " = $" << (item1.GetQuantity()*item1.GetPrice()) << endl;
   cout << item2.GetName() << " " << item2.GetQuantity() << " @ $" <<
   item2.GetPrice() << " = $" << (item2.GetQuantity()*item2.GetPrice()) << endl;

   totalCost = (item1.GetQuantity()*item1.GetPrice()) + (item2.GetQuantity()*item2.GetPrice());

   cout << endl;
   cout << "Total: $" << totalCost << endl;

   return 0;
}
