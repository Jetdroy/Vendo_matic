# Vendo_matic
A working vending machine prompting user to input money and select items and return change in coins

First i load a file to read the vending machine item list

Then A main menu must display when the software runs, presenting the following options:

(1) Display Vending Machine Items
(2) Purchase
(3) Exit

The vending machine is automatically restocked each time the application runs.
When the customer selects "(1) Display Vending Machine Items", they're presented
with a list of all items in the vending machine with its quantity remaining:

Each vending machine product has a slot identifier and a purchase price.
Each slot in the vending machine has enough room for 5 of that product.
Every product is initially stocked to the maximum amount.
A product that has run out must indicate that it's SOLD OUT.

When the customer selects "(2) Purchase", they're guided through the purchasing
process menu:

(1) Feed Money
(2) Select Product
(3) Finish Transaction
Feed menu allows the user to put in a certain dollar amount to the vending machine

After selecting the product:
Depending on item selected a message will be populated associated with it e.g.:
All chip items print "Crunch Crunch, Yum!"
All candy items print "Munch Munch, Yum!"
All drink items print "Glug Glug, Yum!"
All gum items print "Chew Chew, Yum!"

Selecting "(3) Finish Transaction" allows the customer to complete the
transaction and receive any remaining change.

The machine returns the customer's money using nickels, dimes, and quarters
(using the smallest amount of coins possible).
The machine's current balance updates to $0 remaining.

each transaction is logged with the date and time

working on a sales report that shows the total sales since the machine started. 
