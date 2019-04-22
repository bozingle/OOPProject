package user;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class AllUsers implements Serializable
{
	private Map<String,String> passwords;
	private Map<String,String> email;
	private Map<String,String> address;
	private Map<String, Integer> card;
	/**
	 * Creates a empty set of user information
	 */
	public AllUsers()
	{
		// TODO Auto-generated constructor stub
		passwords = new HashMap<String,String>();
		email = new HashMap<String,String>();
		address = new HashMap<String,String>();
		card = new HashMap<String,Integer>();	
	}
	/**
	 * adds a user to the set of users
	 * @param name the username
	 * @param pass the password
	 * @param email the user's email address
	 * @param mailing the user's mailing address
	 * @param cardNum the user's credit card number
	 */
	public void addUser(String name, String pass, String email, String mailing, int cardNum)
	{
		passwords.put(name, pass);
		this.email.put(name, email);
		address.put(name, mailing);
		card.put(name, cardNum);
	}
	/**
	 * Checks if the username and password match
	 * @param username the given username
	 * @param check the given password
	 * @return true if the password fits the username, false otherwise
	 */
	public boolean checkPassword(String username, String check)
	{
		if(passwords.get(username).equals(check))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	/**
	 * Returns the given user's email address
	 * @param user whose email to get
	 * @param pass the user's password
	 * @return the user's email, if the password is correct. Null otherwise
	 */
	public String getEmail(String user, String pass)
	{
		String ret = null;
		if(checkPassword(user,pass))
		{
			ret = email.get(user);
		}
		return ret;
	}
	/**
	 * Returns the given user's mailing address
	 * @param user whose address to get
	 * @param pass the user's password
	 * @return the user's mailing address, if the password is correct. Null otherwise.
	 */
	public String getAddress(String user, String pass)
	{
		String ret = null;
		if(checkPassword(user,pass))
		{
			ret = address.get(user);
		}
		return ret;
	}
	/**
	 * Returns the given user's credit card number
	 * @param user whose card to get
	 * @param pass the user's password
	 * @return the user's credit card number, if the password is correct. -1 otherwise
	 */
	public int getCard(String user, String pass)
	{
		int ret = -1;
		if(checkPassword(user,pass))
		{
			ret = card.get(user);
		}
		return ret;
	}

}
