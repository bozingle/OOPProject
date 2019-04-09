/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

public class BookMenu {
    
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
        System.out.println("'displays books 1 - 10'");
        System.out.println("Type 'N' for next page");
        //this will only display on pages 2 - 10
        System.out.println("Type 'P' for previous page");
        
        System.out.println("Enter number to see book info");       
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
            System.out.println("This is where your cart will display\nEnter Number:");
        }
        else if(a == 3){
        	//Books and amount need to go here at some point.
            System.out.println("Books and amount...\n1. Purchase\n2. Cancel");
            Scanner user_input = new Scanner(System.in);
            int choice = user_input.nextInt();
            if (choice == 1) {
            	OSS system = new OSS();
            	system.bankInteractionConfirmation("Felix");
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
        Scanner user_input = new Scanner(System.in);
        int choice;
        foo.displaybegin();
        
        
        while (true){            
            foo.startMenu();
            System.out.print("Enter number: ");
            choice = user_input.nextInt();
            
            if(choice == 1){
                System.out.println("This is where the login logic will be displayed");
                System.out.println("\n");
                //I am assuming that the login was succesful
                while(true){
                    foo.mainMenu();
                    System.out.println("Enter Number: ");
                    choice = user_input.nextInt();
                    if (choice != 7){
                        foo.userMenu(choice);
                    }
                    else{
                        break;
                    }
                }
            }
            else if(choice == 2){
                System.out.println("This is where the create account logic will be displayed");
            }
            else if(choice == 3){
                System.out.println("Goobbye!");
                break;
            }
        }        
    }    
}
