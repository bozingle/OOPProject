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
    static String bookListFP = "";
    bookCart cart = new bookCart();
    BookList bL = new BookList(this.bookListFP);
    
    OSS(){
    }
    
    public void addToCart(int index, int quantity) {
		cart.pushToCart(index, quantity);
	}
    

    //Will verify credit card with the bank.
    public boolean bankInteractionConfirmation(String userName){
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
	public void createDeliveryOrder(String username) {
         
	}
        
    public void createAccount(){
        
    }
    
    public void displayCart() {
		Set<Integer> cartSet = cart.getCartItems();
		int iter = 1;
		for (int index : cartSet) {
			System.out.println(iter + ")"+ bL.getShortInfo(index));
			iter++;
		}
	}
    
    //Display 10 books
    public void display10(int startIndex, int endIndex) {
    	int iter = 1;
    	for (int i = startIndex; i < endIndex; i++) {
    		System.out.println(iter + ")"+ bL.getShortInfo(i));
    		iter++;
    	}
    }
    
    public void login(){
        
    }
    
    //Select book
    public void selectBook(int index) {
    	String info = bL.getLongInfo(index);
    	System.out.println(info);
    }
}
