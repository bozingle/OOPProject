package oop;

import java.util.Scanner;

public class BookMenu {
	static OSS system = new OSS();
	static Scanner keyboard = new Scanner(System.in);
	String username = "";// Can change later to whatever dhruv has
	
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
        System.out.println("7. Exit");
    }
    
    void BookMenu(){        
    	int tenSet = 0;//Indicates which set of books to display. When tenSet = 0,display10 will display books 0-9, and it keeps displaying similar intervals as you increment tenSet. 
        int startIndex = 0;
        int endIndex = 9;
        String choice = "";
    	while (true) {
    		System.out.println(choice);
        	startIndex = (tenSet*10);
        	endIndex = ((tenSet+1)*10-1);
	    	System.out.println("OOP Books("+(startIndex+1)+"-"+(endIndex+1)+")");
	        system.display10(startIndex, endIndex);
	        System.out.println("Enter 'P' for previous page\t"
	        		+ "Enter 'N' for next page\n"
	        		+ "\tEnter number to see book info or C to cancel:");
	        while ((choice.length() > 1 || choice.length() == 0) && !(choice.equals("P")) || (choice.equals("N")) || (choice.matches("\\d")) || (choice.equals("N")) || (choice.equals("C")))
	        	choice = keyboard.nextLine().toUpperCase();
	        if (choice.equals("P"))
	        	tenSet--;
	        else if (choice.equals("N")) 
	        	tenSet++;
	        else if (choice.matches("\\d")) {
	        	System.out.println("Picking book");
	        	int index = Integer.parseInt(choice) - 1;
	        	system.selectBook(index);
	        	System.out.println("Purchase book(Y/N): ");
	        	while ((choice.length() > 1 || choice.length() == 0) && !(choice.equals("Y")) || (choice.equals("N"))) {
	        			choice = keyboard.nextLine();
	        			if (!(choice.equals("Y")) || (choice.equals("N")))
	        				System.out.println("Please give correct input.");
	        	}
	        	if (choice.equals("Y")) {
	        		int quantity;
	        		while ((choice.length() > 1 || choice.length() == 0) && !(choice.matches("\\d")))
	        				choice = keyboard.nextLine();
	        		quantity = Integer.parseInt(choice);
	        		system.addToCart(index,quantity);
	        	}
	        }
	        else if (choice.equals("C")) 
	        	break;
	        choice = "";
        }
    }
    
    void BookInfo(){
        System.out.println("'This is where the book info will display'");
        System.out.println("Type 'a' to add to cart or ");
    }
    
    void userMenu(int a){
        BookMenu foo = new BookMenu();
        if (a == 1){
           foo.BookMenu();
        }
        else if(a == 2){
        	//Assumes a user is logged in.
            system.displayCart();
        }
        else if(a == 3){
            //Books and amount need to go here at some point.
            system.displayCart();
            int choice = keyboard.nextInt();
            if (choice == 1) {
            	boolean accepted = system.bankInteractionConfirmation(username);
            	if (accepted) {
            		system.createDeliveryOrder(username);
            	}
            }
            else {
            	
            }
        }
        else if(a == 4){
            foo.aboutPage();
        }
        else if(a == 5){
            System.out.println("This will display account info"
                    + "like the username, creditcard info"
                    + "and address info");
        }
        else if(a == 6){
            foo.startMenu();
        }
        else if(a == 7){
            System.out.println("Goobbye!");
        }
    }   
    
   public static void main(String[] args) {
        
        BookMenu foo = new BookMenu();
        int choice;
        foo.displaybegin();
        
        
        while (true){            
            foo.startMenu();
            System.out.print("Enter number: ");
            choice = keyboard.nextInt();
            
            if(choice == 1){
                System.out.println("This is where the login logic will be displayed");
                System.out.println("\n");
                while(true){
                    foo.mainMenu();
                    System.out.println("Enter Number: ");
                    choice = keyboard.nextInt();
                    if (choice != 7){
                        foo.userMenu(choice);
                    }
                    else{
                        break;
                    }
                }
            }
            else if(choice == 2){
                system.createAccount();
            }
            else if(choice == 3){
                System.out.println("Goobbye!");
                break;
            }
        }        
    }   
}
