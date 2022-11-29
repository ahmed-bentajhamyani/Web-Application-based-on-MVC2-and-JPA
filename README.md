<p align="center">
	<img src="https://user-images.githubusercontent.com/101653735/202849820-dfeaabcf-4dd9-4452-a847-5a767462fd9d.png" >
</p>

# Web Application based on MVC2 and JPA

This is an implementation of an e-commerce web site, the web application must respect the MVC2 design pattern that's means one servlet will contain all necessary actions of a specific management.

## Table of contents
[Class diagram](#class-diagram)

[Testing the Application](#testing-the-application)
* [Products](#products)
* [Login](#login)
* [Signup](#signup)
* [Shopping Cart](#shopping-cart)
* [Logout](#logout)

## Class diagram

The class diagram used to implement this web application composed of four classes "User", "Product", "Category", "Cart" and "CartDetail":

<p align="center">
	<img width="937" alt="image" src="https://user-images.githubusercontent.com/101653735/204596688-6a04bcf6-9644-40e3-8003-2e37e9657171.png">
</p>

## Testing the Application

### Products

The front page of our web site contains all our products:

<p align="center">
	<img width="925" alt="1" src="https://user-images.githubusercontent.com/101653735/204595909-558b4653-b7ed-498c-a0a1-9a1e6f8f1288.png">
</p>

To see more details of a product, you have to click to "More Details" button:

<p align="center">
	<img width="925" alt="2" src="https://user-images.githubusercontent.com/101653735/204595959-1b4fd9b5-9703-43bb-99cf-8102dbef5a8c.png">
</p>

And to add the product to your shopping cart you have to click "Add To Cart" button, but first you have to signup if you don't have an account or login if you do. 

### Login

When you click the user icon in the navbar the login form appears:

<p align="center">
	<img width="925" alt="3" src="https://user-images.githubusercontent.com/101653735/204504831-4ebaf3ed-3689-402e-895b-24c1d47101ce.png">
</p>

So if you already have an account you enter your username and you password and you're logged in. If you don't have an account you click the link says "Don't have an account".

### Signup

<p align="center">
	<img width="926" alt="4" src="https://user-images.githubusercontent.com/101653735/204505419-010ef411-c80d-406c-b497-de197b32e514.png">
</p>

In the signup form you have to enter your email, username and password.

### Shopping Cart

To open your cart you have to click the shooping cart icon in the navbar.
If you're not logged a page appears and says "you haven't login. please login":

<p align="center">
	<img width="924" alt="Cart without login" src="https://user-images.githubusercontent.com/101653735/204506892-6f179c18-4e70-4814-bed5-21993e6f782a.png">
</p>

You logged in and your shopping cart is empty you have to add items to it now:

<p align="center">
	<img width="925" alt="Cart without product" src="https://user-images.githubusercontent.com/101653735/204507093-2695db92-f370-481a-b791-ae7989a89246.png">
</p>

So you clicked the button says "Show now" and you added an items to your shopping cart:

<p align="center">
	<img width="923" alt="6" src="https://user-images.githubusercontent.com/101653735/204507361-683f225d-afbb-4992-9b19-f4e2b30888a1.png">
</p>

You can by clicking the plus button add the quantity of the product in your shopping cart or the minus button to subtract the quantity:

<p align="center">
	<img width="925" alt="7" src="https://user-images.githubusercontent.com/101653735/204507832-67038f93-7657-4f68-af42-642c074f431a.png">
</p>

As you see there is a card also contains the price total of the product in the cart:

<p align="center">
	<img width="923" alt="8" src="https://user-images.githubusercontent.com/101653735/204508547-433d057b-55a4-44d3-946d-8a6c4677a473.png">
</p>

And the checkout button to make the transaction, if the transaction complete we go to the front page and a success alert appears:

<p align="center">
	<img width="925" alt="9" src="https://user-images.githubusercontent.com/101653735/204509212-1e5380a3-a6d1-4603-a818-90839e1e6801.png">
</p>

### Logout

Finally you can logout from our web site:

<p align="center">
	<img width="926" alt="10" src="https://user-images.githubusercontent.com/101653735/204511609-c05da9eb-a92a-4129-a44c-730f5afbbf5d.png">
</p>
