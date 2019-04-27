package oop;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class Accounts implements Serializable{
	Map <String,String> userAccountData;
	Set <String> emails;
	String loggedIn = "";
	String accountFP = "C:\\Users\\joggl\\eclipse-workspace\\oop\\src\\oop\\Accounts.dat";
	
	Accounts() {
		//Deserialize if the hashmap already exists, otherwise instantiate a new hashmap
		Accounts allAccounts;
		try {
			
			FileInputStream file = new FileInputStream(accountFP); 
            ObjectInputStream in = new ObjectInputStream(file); 
            allAccounts = (Accounts)in.readObject();
            in.close();
            file.close();
            this.userAccountData = allAccounts.userAccountData;
            this.emails = allAccounts.emails;
		}
		catch(Exception e) {
			System.out.println(e);
			userAccountData = new HashMap<String,String>();
			this.emails = new HashSet<String>();
		}
	}
	
	void createAccount() { 
		Scanner keyboard = new Scanner(System.in);
		String mapping = "";
		String email, username, password,phonenumber,creditnum;
		while (true) {
		    System.out.println("Please enter your email : ");      
		    email = keyboard.nextLine().toUpperCase();
		    //checks to see if email entered is already associated with an account.
		    if (!emails.contains(email))
		    	break;
		    else
		    	System.out.println("Your email already exists in the system.");
		}
	    mapping += email+",";
	    emails.add(email);
	    
	    while (true) {
		    System.out.println("Please enter your username : ");       
		    username = keyboard.nextLine().toUpperCase();
		    if (this.userAccountData.get(username) == null)
		    	break;
		    else
		    	System.out.println("Username already exists.");
	    }
	    while (true) {
	    	System.out.println("Please enter your phone number : "); 
	    	phonenumber = keyboard.nextLine();
	    	if (phonenumber.matches("\\d+"))
	    		break;
	    	System.out.println("Please enter an appropriate phone number.");
	    }
	    mapping += phonenumber+",";
	    System.out.println("Enter an address :");
	    mapping += keyboard.nextLine()+",";
	    while (true) {
	    	System.out.println("Enter a credit card number :");
	    	creditnum = keyboard.nextLine();
	    	if (creditnum.matches("\\d+"))
	    		break;
	    	System.out.println("Please enter an appropriate value.");
	    }
	    mapping += creditnum+",";
	    while (true) {
		    System.out.println("Please enter your password (at least 5 characters) : ");       
		    password = keyboard.nextLine();
		    if (password.length() >= 5)
		    	break;
		    else
		    	System.out.println("Your password is not long enough.");
	    }
	    mapping += password;
	    this.userAccountData.put(username, mapping);
	}    

    void logIn() {
    	Scanner keyboard = new Scanner(System.in);
    	String user, password, requiredPass;
    	while(true) {
	        System.out.println("Please enter your username : ");
	        user = keyboard.nextLine().toUpperCase();
	        
	        System.out.println("Please enter your password : ");
	        password = keyboard.nextLine();
	        if (this.userAccountData.get(user) != null) {
		        requiredPass = this.userAccountData.get(user).split(",")[4];
		        
		        if (this.userAccountData.get(user) != null && requiredPass.equals(password) ) {
		        	this.loggedIn = user;
		        	System.out.println("Login was successful.");
		        	break;
		        }
		        else {
		        	System.out.println("Login unsuccessful. Try again.");
		        }
	        }
	    }
    }
    void displayAccountInfo() {
    	String[] corres = {"Email: ", "Phone number: ", "Address: ", "Credit Card number: "};
    	int i = 0;
    	for (String str : this.userAccountData.get(loggedIn).split(",")) {
    		System.out.println(corres[i]+str);
    		i++;
    		if (i == corres.length) 
    			break;
    	}
    	System.out.println("");
    }
    void logOut() {
    	if (!loggedIn.equals("")) {
    		loggedIn = "";
    	}
    	else {
    		System.out.println("Not logged in.");
    	}
    }
    //Serialize data
    void save() {
    	try {
   		 	FileOutputStream file = new FileOutputStream(this.accountFP); 
            ObjectOutputStream out = new ObjectOutputStream(file); 
            out.writeObject(this); 
            out.close(); 
            file.close();
   		}
   		catch(Exception e) {
   			System.out.println("Error while saving account information.");
   		}
    }
}
