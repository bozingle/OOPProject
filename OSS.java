/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounts;

/**
 *
 * @author thoma_000
 */
import java.io.*;
import java.util.Scanner;
//This file will communicate with the supplier, user interface, and individual components of the project.


public class OSS {
    bookCart cart[];
    static int conNum;
    OSS(){
        try{
            File file = new File("C:\\Users\\thoma_000\\Documents\\NetBeansProjects\\Accounts\\src\\accounts\\test.txt");
            Scanner inputfile = new Scanner(file);
            conNum = Integer.parseInt(inputfile.nextLine());
            inputfile.close();
        }
        catch(Exception e){}
        
    }
    //Will verify credit card with the bank.
    public void bankInteractionConfirmation(String userName){
            //Need to decide on how to save user data still. This is for now.
            Bank bank = new Bank();
            if (bank.verify()){
                    System.out.println("Credit card was approved.\n");
                    createDeliveryOrder(userName);
                    saveConfirmationNumber(userName);
            }
            else {
            System.out.println("Credit card was not approved.\n");

    	}
     }
	
	//Will create a delivery order and will be handled by the supplier interface.
	public void createDeliveryOrder(String userName) {
            conNum++;
            PrintWriter conNumFile;
            BufferedWriter in;
            try{
                conNumFile = new PrintWriter("C:\\Users\\thoma_000\\Documents\\NetBeansProjects\\Accounts\\src\\accounts\\test.txt");
                conNumFile.println(conNum);
                in = new BufferedWriter(new FileWriter("C:\\Users\\thoma_000\\Desktop\\Account\\"+userName+".txt",true));
                in.write(conNum);
                conNumFile.close();
                in.close();
            }
            catch(Exception e) {}
	}
        
        public void createAccount(){
            String username, email, address, password;
            String filename;
            File file;
            PrintWriter outputFile;
            
            Scanner keyboard = new Scanner(System.in);
            while (true){
                System.out.print("Enter Username: ");
                username = keyboard.nextLine();

                filename = username + ".txt";
                try{
                    file = new File("C:\\Users\\thoma_000\\Desktop\\Account\\"+filename);
                    if (file.createNewFile()){
                       break;
                    }
                }
                catch(Exception e){}
            }
            
            email = keyboard.nextLine();
            address = keyboard.nextLine();
            password = keyboard.nextLine();
            try{
                outputFile = new PrintWriter("C:\\Users\\thoma_000\\Desktop\\Account\\"+filename);
                outputFile.println(username+","+email+","+address+","+password);
                outputFile.close();
            }
            catch(Exception e){}
            
        }
        
        
        public void login(){
            File file;
            Scanner keyboard = new Scanner(System.in);
            String username, filename,decision;
            
            while(true){
                System.out.println("Username: ");
                username = keyboard.nextLine();
                filename = username+".txt";
                try{
                    file = new File("C:\\Users\\thoma_000\\Desktop\\Account\\"+filename);
                    if (file.exists()){
                        break;
                    }
                    else{
                        System.out.println("Would you like to make an account?(Y/N)");
                        decision = keyboard.nextLine();
                        if (decision.equals("Y")){
                            createAccount();
                        }
                    }
                }
                catch(Exception e){}
                
            }
            
        }
	
	//Saves the confirmation number into user's personal file.
	public void saveConfirmationNumber(String userName) {
		int confirmationnum = 2;
		FileWriter fw;
		PrintWriter outputFile;
		try {
			File file = new File("C:\\Users\\jreznick\\Texas Tech University\\Quail Call - Joel\\OOPProject\\"+userName+".txt");
			
			if(file.createNewFile()) {
				System.out.println("Would you like to make a new account?");
				//Handles making a new account
			}
			fw = new FileWriter("C:\\Users\\jreznick\\Texas Tech University\\Quail Call - Joel\\OOPProject\\"+userName+".txt",true);
			outputFile = new PrintWriter(fw);
			outputFile.println(confirmationnum);
			outputFile.close();
		}
		catch(Exception e){
			System.out.println("Couldn't create the file or there was an issue with put information to the file.");
		}
		
	}
	
}
