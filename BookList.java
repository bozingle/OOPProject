package oop;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookList 
{
	Map<Integer,Book> top100;
	int numOfBooks;
	/**
	 * Creates a booklist from the given .csv file
	 * @param fileName
	 */
	public BookList(String fileName) 
	{
		// TODO Auto-generated constructor stub
		List<String[]> rawData = readFile(fileName,",");
		top100 = new HashMap<Integer,Book>();
		for(int i = 1; i < rawData.size(); i++)
		{
			Book b = new Book(rawData.get(i));
			top100.put(i,b);
			numOfBooks = i;
		}
	}
	/**
	 * Returns a short description of the selected book
	 * @param index which book to describe
	 * @return Title, author, price
	 */
	public String getShortInfo(int index)
	{
		Book get = top100.get(index);
		String little = String.format("Title: %30s Author: %20s Price: %.2f", get.getTitle(), get.getAuthor(), get.getPrice());
		return little;
	}
	/**
	 * Returns a full description of the selected book
	 * @param index which book to describe
	 * @return Title, author, price, shipping
	 * 			Year, publisher, supplier, stock
	 * 			Short Summary
	 */
	public String getLongInfo(int index)
	{
		Book get = top100.get(index);
		String start = getShortInfo(index);
		String stock;
		if(get.getStock() > 0)
		{
			stock = Integer.toString(get.getStock());
		}
		else
		{
			stock = Book.OUT_OF_STOCK;
		}
		String big = String.format("Shipping: %.2f\nYear: %4d Publisher: %16s Supplier: %16s Stock: %s\nSummary:\n%s\n"
								,get.getShipping(),get.getYear(),get.getPublisher(),get.getSupplier(),stock,get.getSummary());
		return start + big;
	}
	/**
	 * Buys a number of books, reducing the amount of stock remaining
	 * @param index which book to buy
	 * @param quantity the cost of buying the books: (price*quantity) + shipping
	 */
	public double buy(int index, int quantity)
	{
		Book get = top100.get(index);
		try
		{
			get.reduceStock(quantity);
		}
		catch(IllegalArgumentException e)
		{
			throw new IllegalArgumentException(e);
		}
		double together = get.getPrice() * quantity;
		return together + get.getShipping();
	}
	
	/**
	 * Reads a formatted .csv file to convert into a booklist
	 * @param fileName which file to read
	 * @return a list of string arrays that contains the books' information
	 */
	private List<String[]> readFile(String fileName, String split)
	{
		BufferedReader br = null;
        String line = "";
        String csvSplitBy = split;
        List<String[]> info = new ArrayList<String[]>();
        try 
        {
            br = new BufferedReader(new FileReader(fileName));
            while ((line = br.readLine()) != null) 
            {
                String[] adder = line.split(csvSplitBy);
                info.add(adder);
            }

        } 
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        } 
        finally 
        {
            if (br != null) 
            {
                try 
                {
                    br.close();
                } 
                catch (IOException e) 
                {
                    e.printStackTrace();
                }
            }
        }
        return info;
    }
	
	public void updateStock(String filename) {
		try {
			PrintWriter file = new PrintWriter(filename);
			Book b;
			file.println("Number,Name,Author,Publisher,Year,Supplier,Price,Shipping,Stock,Summary");
			for (int i = 1; i <= numOfBooks; i++) {
				b = top100.get(i);
				file.println(i+","+b.getTitle()+","+b.getAuthor()+","+b.getPublisher()+","+b.getYear()+","+b.getSupplier()+","+b.getPrice()+","+b.getShipping()+","+b.getStock()+","+b.getSummary());
			}
			file.close();
		}
		catch(Exception e) {}
	}
	public boolean sufficientQuantity(int index, int quantity) {
		if (getBook(index).getStock() < quantity || quantity <= 0)
			return false;
		return true;
	}
	
	public Book getBook(int index) {
		return top100.get(index);
	}
}
