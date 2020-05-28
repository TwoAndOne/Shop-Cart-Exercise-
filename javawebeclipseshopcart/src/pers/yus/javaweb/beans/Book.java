package pers.yus.javaweb.beans;

import java.io.Serializable;

public class Book implements Cloneable , Serializable
{
	private int id;
	private String name;
	private double price;
	private int bookCount;
	private String author;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public double getPrice()
	{
		return price;
	}
	public void setPrice(double price)
	{
		this.price = price;
	}
	public int getBookCount()
	{
		return bookCount;
	}
	public void setBookCount(int bookCount)
	{
		this.bookCount = bookCount;
	}
	public String getAuthor()
	{
		return author;
	}
	public void setAuthor(String author)
	{
		this.author = author;
	}
	
	@Override
	public Object clone() {
		Book newBook = null;
		try
		{
			newBook = (Book)super.clone();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return newBook;
	}
}
