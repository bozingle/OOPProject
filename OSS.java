import java.io.PrintWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
//This file will communicate with the supplier, user interface, and individual components of the project.

public class OSS {
	//Will verify credit card with the bank.
	public void bankInteractionConfirmation(String userName){
		//Need to decide on how to save user data still. This is for now.
		Bank bank = new Bank();
		if (bank.verify()){
        		System.out.println("Credit card was approved.\n");
        		createDeliveryOrder();
        		saveConfirmationNumber(userName);
		}
		else {
    		System.out.println("Credit card was not approved.\n");
    	}
	}
	
	//Will create a delivery order and will be handled by the supplier interface.
	public void createDeliveryOrder() {
		
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
