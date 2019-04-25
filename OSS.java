/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop;

import java.io.*;
import java.util.Scanner;
//This file will communicate with the supplier, user interface, and individual components of the project.
import java.util.Set;


public class OSS {
    Orders orderList = new Orders();
    static String bookListFP = "C:\\Users\\joggl\\eclipse-workspace\\oop\\src\\oop\\Top25.csv";
    bookCart cart = new bookCart();
    BookList bL = new BookList(this.bookListFP);
    Accounts accs = new Accounts();
    
    OSS(){
    }
    
    public void addToCart(int index, int quantity) {
    	if (bL.sufficientQuantity(index,quantity))
    		cart.pushToCart(index, quantity);
    	else
    		System.out.println("Can't purchase this amount of the book selected.");
	}
    

    //Will verify credit card with the bank.
    public boolean bankInteractionConfirmation(){
        //Need to decide on how to save user data still. This is for now.
        Bank bank = new Bank();
        if (bank.verify()){
                System.out.println("Credit card was approved.\n");
                return true;
        }
        else {
        	System.out.println("Credit card was not approved.\n");
        	return false;
    	}
     }
	
	//Will create a delivery order and will be handled by the supplier interface.
	public void createDeliveryOrder() {
         Orders ord = new Orders();
         String[] data = accs.userAccountData.get(accs.loggedIn).split(",");
         String orderData = "";
         Book b;
         for (int i : cart.getCartItems()) {
        	 b = bL.getBook(i);
        	 orderData += b.getTitle()+"~"+b.getPrice()*cart.cart.get(i)+"~"+cart.cart.get(i)+",";
        	 bL.buy(i, cart.cart.get(i));
         }
         ord.putPurchaseData(accs.loggedIn,data[0],orderData);
         ord.save();
         bL.updateStock(bookListFP);
         cart.clearCart();
	}
        
    public void createAccount(){
        accs.createAccount();
        accs.save();
    }
    
    void displayAccountInfo() {
    	accs.displayAccountInfo();
    }
    
    public void displayCart() {
		Set<Integer> cartSet = cart.getCartItems();
		int iter = 1;
		for (int index : cartSet) {
			System.out.println(iter + ")"+ bL.getShortInfo(index) + "\tQuantity: "+cart.getFromCart(index));
			iter++;
		}
		System.out.println("");
	}
    
    public void displayPrevPurchase(int conNum) {
    	Orders ord = new Orders();
    	ord.displayPurchaseData(accs.loggedIn, conNum);
    }
    
    public void displayBooks(int startIndex, int endIndex) {
    	if (startIndex >= 1 && endIndex <= bL.numOfBooks) {
    		System.out.println("OOP Books("+startIndex+"-"+endIndex+")");
	    	for (int i = startIndex; i < endIndex; i++) {
	    		System.out.println(i + ")"+ bL.getShortInfo(i));
	    	}
    	}
    	else if(startIndex >= 1){
    		System.out.println("OOP Books("+startIndex+"-"+bL.numOfBooks+")");
    		for (int i = startIndex; i < bL.numOfBooks+1; i++) {
    			System.out.println(i + ")"+ bL.getShortInfo(i));
    		}
    	}
    }
    
    public void login(){
        accs.logIn();
    }
    
    public void logout() {
    	accs.logOut();
    }
    
    //Select book
    public void selectBook(int index) {
    	String info = bL.getLongInfo(index);
    	System.out.println(info);
    }
}
