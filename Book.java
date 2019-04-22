package books;

public class Book 
{
	private String title;
	private String author;
	private String publisher;
	private int year;
	private String supplier;
	private double price;
	private double shipping;
	private int stock;
	private String summary;
	public static final String OUT_OF_STOCK = "Item out of stock";
	public static final String NOT_ENOUGH = "Not enough stock";
	/**
	 * 
	 * @param info
	 */
	public Book(String[] info) 
	{
		// TODO Auto-generated constructor stub
		title = info[1];
		author = info[2];
		publisher = info[3];
		year = new Integer(info[4]);
		supplier = info[5];
		price = new Double(info[6]);
		shipping = new Double(info[7]);
		stock = Math.max(new Integer(info[8]), 0);
		summary = info[9];
	}
	/**
	 * 
	 * @return
	 */
	public String getTitle()
	{
		return title;	
	}
	/**
	 * 
	 * @return
	 */
	public String getAuthor()
	{
		return author;	
	}
	/**
	 * 
	 * @return
	 */
	public String getPublisher()
	{
		return publisher;	
	}
	/**
	 * 
	 * @return
	 */
	public int getYear()
	{
		return year;	
	}
	/**
	 * 
	 * @return
	 */
	public String getSupplier()
	{
		return supplier;	
	}
	/**
	 * 
	 * @return
	 */
	public double getPrice()
	{
		return price;	
	}
	/**
	 * 
	 * @return
	 */
	public double getShipping()
	{
		return shipping;	
	}
	/**
	 * 
	 * @return
	 */
	public int getStock()
	{
		return stock;	
	}
	/**
	 * 
	 * @return
	 */
	public String getSummary()
	{
		return summary;	
	}
	/**
	 * 
	 * @param bought
	 * @throws IllegalArgumentException
	 */
	public void reduceStock(int bought) throws IllegalArgumentException
	{
		if(stock - bought >= 0)
		{
			stock -= bought;
		}
		else if(stock == 0)
		{
			throw new IllegalArgumentException(OUT_OF_STOCK);
		}
		else
		{
			throw new IllegalArgumentException(NOT_ENOUGH);
		}
	}
	
	

}
