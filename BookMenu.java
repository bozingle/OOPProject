package oop;

import java.util.Scanner;

public class BookMenu {
	static OSS system = new OSS();
	static Scanner keyboard = new Scanner(System.in);
	
    void displaybegin(){
        System.out.println("********************************");
        System.out.println("* Welcome to OOP Top 100 Books *");
        System.out.println("********************************");
        System.out.println("*                              *");
        System.out.println("*   __________________________ *");
        System.out.println("* ____________________________ *");
        System.out.println("* ____________________________ *");
        System.out.println("* ____________________________ *");
        System.out.println("* ________________________     *");
        System.out.println("*   __________________________ *");
        System.out.println("* ____________________________ *");
        System.out.println("* ____________________________ *");
        System.out.println("* ____________________________ *");
        System.out.println("*                              *");
        System.out.println("********************************");        
    }
    
    void startMenu(){
        System.out.println("1. Login");
        System.out.println("2. Create Account");
        System.out.println("3. exit");
    }
    
    void aboutPage(){
        System.out.println("OOP Top 100 Books is a text based online shopping "
                + "service to purchase books that are considered to be the top 100.");        
    }
    
    void mainMenu(){
        System.out.println("1. Browse Top 100 Books");
        System.out.println("2. See Cart");
        System.out.println("3. Check Out");
        System.out.println("4. About");
        System.out.println("5. Account Info");
        System.out.println("6. Logout");
    }
    
    void BookMenu(){        
    	int tenSet = 0;//Indicates which set of books to display. When tenSet = 0,display10 will display books 0-9, and it keeps displaying similar intervals as you increment tenSet. 
        int startIndex = 1;
        int endIndex = 10;
        String choice = "";
    	while (true) {
    		System.out.println(choice);
        	startIndex = (tenSet*10)+1;
        	endIndex = (tenSet+1)*10;
	    	
	    	system.displayBooks(startIndex, endIndex);
	        System.out.println("Enter 'P' for previous page\t"
	        		+ "Enter 'N' for next page\n"
	        		+ "\tEnter number to see book info or C to cancel:");
	        while ((choice.length() > 1 || choice.length() == 0) && !(choice.equals("P") || (choice.equals("N")) || (choice.matches("\\d")) || (choice.equals("N")) || (choice.equals("C"))))
	        	choice = keyboard.nextLine().toUpperCase();
	        if (choice.equals("P") && tenSet-1 >=0)
	        	tenSet--;
	        else if (choice.equals("N")) 
	        	tenSet++;
	        else if (choice.matches("\\d")) {
	        	System.out.println("Picking book");
	        	int index = Integer.parseInt(choice);
	        	system.selectBook(index);
	        	System.out.println("Purchase book(Y/N): ");
	        	choice = "";
	        	while ((choice.length() > 1 || choice.length() == 0) && !(choice.equals("Y")) || (choice.equals("N"))) {
	        			choice = keyboard.nextLine().toUpperCase();
	        			if (!(choice.equals("Y") || (choice.equals("N")))) {
	        				System.out.println("Please give correct input.");
	        				choice = "";
	        			}
	        	}
	        	if (choice.equals("Y")) {
	        		int quantity;
	        		choice = "";
	        		while ((choice.length() < 1 || choice.length() == 0) && !(choice.matches("\\d"))) {
	        			System.out.println("How many would you like to buy?");
	        			choice = keyboard.nextLine();
	        		}
	        		quantity = Integer.parseInt(choice);
	        		system.addToCart(index,quantity);
	        	}
	        }
	        else if (choice.equals("C")) 
	        	break;
	        choice = "";
        }
    }
    
    void userMenu(String a){
        BookMenu foo = new BookMenu();
        if (a.equals("1")){
           foo.BookMenu();
        }
        else if(a.equals("2")){
        	//Assumes a user is logged in.
            system.displayCart();
        }
        else if(a.equals("3")){
            //Books and amount need to go here at some point.
            system.displayCart();
            String choice;
            while (true) {
	            System.out.println("Make payment(Y/N):");
	            choice = keyboard.nextLine().toUpperCase();
	            if (choice.equals("Y") || choice.equals("N"))
	            	break;
	            System.out.println("Please use appropriate input.");
            }
            
            if (choice.equals("Y")) {
            	boolean accepted = system.bankInteractionConfirmation();
            	if (accepted) {
            		system.createDeliveryOrder();
            	}
            }
        }
        else if(a.equals("4")){
            foo.aboutPage();
        }
        else if(a.equals("5")){
        	String choice;
        	while (true) {
	        	System.out.println("1)See User information.\n2)See previous purchases with confirmation numbers.\nEnter number: ");
	        	choice = keyboard.nextLine();
	        	if (choice.length() == 1 && choice.matches("\\d"))
	        		break;
	        	System.out.println("Please give appropriate input.");
        	}
        	if (choice.equals("1"))
        		system.displayAccountInfo();
        	else if (choice.equals("2")) {
        		System.out.println("Enter confirmation number: ");
        		choice = keyboard.nextLine();
        		system.displayPrevPurchase(Integer.parseInt(choice));
        	}
            
        }
        else if(a.equals("6")){
        	system.logout();
        }
    }   
    
 public static void main(String[] args) {
        
        BookMenu foo = new BookMenu();
        String choice;
        foo.displaybegin();
        
        
        while (true){            
            foo.startMenu();
            System.out.print("Enter number: ");
            choice = keyboard.nextLine();
            
            if(choice.contentEquals("1")){
                system.login();
                while(true){
                    foo.mainMenu();
                    System.out.println("Enter Number: ");
                    choice = keyboard.nextLine();
                    foo.userMenu(choice);
                    if (choice.equals("6")){
                     break;   
                    }
                }
                choice = "";
            }
            else if(choice.equals("2")){
                system.createAccount();
            }
            else if(choice.equals("3")){
                System.out.println("Goobbye!");
                break;
            }
        }        
    }
}
