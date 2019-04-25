package oop;
import java.util.HashMap;
import java.util.Map;
import java.io.*;

/*Objective:
 * Return information about user's orders.
 * If the username is associated with the confirmation number, returns the information about the order.
 * */
public class Orders  implements Serializable
{
	Map<Integer, String> userOrders; //Maps the confirmation number to a username
	Map <Integer, String> orders; //Maps the confirmation number to a formatted string of the cart.
	Integer nextNum;
	static String dataFileName = "C:\\Users\\joggl\\eclipse-workspace\\oop\\src\\oop\\orderData.dat";
	static String saveLocation = "C:\\Users\\joggl\\eclipse-workspace\\oop\\src\\oop\\";
	
	public Orders() 
	{
		Orders allOrders;
		 try
	        {    
	            FileInputStream file = new FileInputStream(dataFileName); 
	            ObjectInputStream in = new ObjectInputStream(file); 
	            allOrders = (Orders)in.readObject(); 
	            in.close();
	            file.close();
	            this.userOrders = allOrders.userOrders;
	            this.orders = allOrders.orders;
	            this.nextNum = allOrders.nextNum;
	        }
		catch(Exception e) {
			this.userOrders = new HashMap<Integer,String>();
			this.orders = new HashMap<Integer, String>();
			this.nextNum = 0;
		}
		
	}
	
	/*Objective:
	 * Display information about confirmation number if the username is associated with the confirmation number.
	 */
	public void displayPurchaseData(String username, int conNum) {
		username = username.toUpperCase();
		
		if (this.userOrders.get(conNum) != null && this.userOrders.get(conNum).contentEquals(username)) {
			String[] stuff = this.orders.get(conNum).split(",");
			
			for (String i : stuff) {
				String[] subStuff = i.split("~");
				System.out.println("Title:\t"+subStuff[0]+" Quantity:\t"+subStuff[2]+" Price:\t$"+subStuff[1]);
			}
			System.out.println();
		}
		else {
			System.out.println("You do not have access to this order, or the order does not exist.");
		}
	}
	
	/*Objective:
	 * Put new data into the hashmap.
	 */
	public void putPurchaseData(String username, String Email, String purchaseDataFormatted) {
		this.userOrders.put(this.nextNum, username);
		this.orders.put(this.nextNum, purchaseDataFormatted);
		System.out.println("Sending an email with your confirmation number."
				+ "\nYour confirmation number: " + this.nextNum);
		this.writeEmail(username);
		this.nextNum++;
	}
	
	public void save() {
		try {
		 FileOutputStream file = new FileOutputStream(Orders.dataFileName); 
         ObjectOutputStream out = new ObjectOutputStream(file);
         out.writeObject(this); 
         out.close(); 
         file.close();
		}
		catch(Exception e) {
			System.out.println("Error while saving confirmation numbers.");
		}
	}
	public void writeEmail(String username) {
		try {
			PrintWriter outputFile = new PrintWriter(this.saveLocation+username+".txt");
			outputFile.println("Your confirmation number is: "+this.nextNum);
            outputFile.close();
		}
		catch(Exception e) {
			
		}
	}
	
	public void reloadPrevSave() {
		Orders oldSave = new Orders();
		this.userOrders = oldSave.userOrders;
		this.orders = oldSave.orders;
		this.nextNum = oldSave.nextNum;
	}
}
