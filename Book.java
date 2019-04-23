package oop;

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
	 * Creates a new book object based on a string array with a specific format
	 * @param info
	 * info[0] order of the book (not used)
	 * info[1] the book's title
	 * info[2] the book's author
	 * info[3] the book's publisher
	 * info[4] the year the book was published (can convert to int)
	 * info[5] the book's supplier
	 * info[6] the book's price (can convert to double)
	 * info[7] the book's shipping price (can convert to double)
	 * info[8] how many books remain in stock (can convert to int, minimum of 0)
	 * info[9] a short summary of the book
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
	 * @return the book's title
	 */
	public String getTitle()
	{
		return title;	
	}
	/**
	 * @return the book's author
	 */
	public String getAuthor()
	{
		return author;	
	}
	/**
	 * @return the book's publisher
	 */
	public String getPublisher()
	{
		return publisher;	
	}
	/**
	 * @return the year the book was published
	 */
	public int getYear()
	{
		return year;	
	}
	/**
	 * @return the book's supplier
	 */
	public String getSupplier()
	{
		return supplier;	
	}
	/**
	 * @return the book's price
	 */
	public double getPrice()
	{
		return price;	
	}
	/**
	 * @return the book's shipping price
	 */
	public double getShipping()
	{
		return shipping;	
	}
	/**
	 * @return how many books are left in stock
	 */
	public int getStock()
	{
		return stock;	
	}
	/**
	 * @return a short summary of the book
	 */
	public String getSummary()
	{
		return summary;	
	}
	/**
	 * Reduces the amount of stock available for this book
	 * @param bought how many books to remove from stock
	 * @throws IllegalArgumentException if bough is negative, stock is zero, or
	 * reducing stock by bought would make stock negative
	 */
	public void reduceStock(int bought) throws IllegalArgumentException
	{
		if(stock - bought >= 0 && bought >= 0)
		{
			stock -= bought;
		}
		else if(stock == 0)
		{
			throw new IllegalArgumentException(OUT_OF_STOCK);
		}
		else if(bought < 0)
		{
			throw new IllegalArgumentException("Invalid purchase");
		}
		else
		{
			throw new IllegalArgumentException(NOT_ENOUGH);
		}
	}
	
	

}
