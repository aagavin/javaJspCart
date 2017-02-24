Assignment2
===

### Author
Aaron Fernandes - 300773526


## Exercise #1: Data Persistence (simulated)

For data persistence I solved this by using java servlet sessions 
  and storing as beans. Beans are stored in `com.AaronFernandes.Assignment2.beans`.
  The two beans manage data transfer for the `Cart` and `Inventory`.

I also use a DTO in the `com.AaronFernandes.Assignment2.models` package. It stores the `Item` object which is a common
 class that is used in both the `Cart` and `Inventory`.


## Exercise #2: Navigation

For navigation I use two servlets located `com.AaronFernandes.Assignment2.servlets`. The `RootServlet` is the default
servlet. This servlet is set in the `web.xml` file as the default session. This servlet sets the inventory class and
then displays all the items by using the `root.jsp` page.

The `root.jsp` displays the items and allows the user to select the quantity of an item and add it to the cart. The user 
can only add only the number of items that exists in the inventory. If an item in the inventory is 0 then that item is 
not shown. When a use selects now many of an item they want then clicks add to cart a **POST** request is made to the 
`/cart` url.
  
The `/Cart` is processed  by the `CartServlet`. The `CartServlet` gets what the user selected then adds that item to the 
 Cart DTO and decrements the inventory of the item in the `Inventory` class. The user is then shown a all items in their 
 cart. The page is displayed using the `cart.jsp` page. The page shows the user their cart and a total price. 
 
From here the the user can go back to the item list and add another item to the cart.