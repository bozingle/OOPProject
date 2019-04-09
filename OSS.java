import java.io.PrintWriter;

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
		//PrintWriter outputFile = new PrintWriter(userName + ".txt", "UTF-8");
		int confirmationNum = 2;
		//outputFile.println(confirmationNum);
	}
	
}
