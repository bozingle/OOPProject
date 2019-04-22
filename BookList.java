package books;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookList 
{
	List<Book> top100;
	
	public BookList(String fileName) 
	{
		// TODO Auto-generated constructor stub
		List<String[]> rawData = readFile(fileName,",");
		List<Book> top100 = new ArrayList<Book>();
		for(int i = 0; i < rawData.size(); i++)
		{
			Book b = new Book(rawData.get(i));
			top100.add(b);
		}
	}
	
	public String getShortInfo(int index)
	{
		Book get = top100.get(index);
		String little = String.format("Title: %30s Author: %20s Price: %.2f", get.getTitle(), get.getAuthor(), get.getPrice());
		return little;
	}
	
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
	
	public void buy(int index, int quantity)
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
	}
	
	/**
	 * 
	 * @param fileName
	 * @return
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
}
