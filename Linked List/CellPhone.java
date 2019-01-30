import java.util.Scanner;
public class CellPhone {
Scanner theKeyboard=new Scanner (System.in);
private long serialNum;
private String brand;
private int year;
private double price;
public CellPhone() 
{
	this.serialNum=0;;
	this.brand="Test";
	this.year=1997;
	this.price=19.99;
}
public CellPhone(long serialNum, String brand, int year, double price) 
{
	this.serialNum=serialNum;
	this.brand=brand;
	this.year=year;
	this.price=price;
}
public CellPhone(CellPhone c) 
{
	this.serialNum=c.serialNum;
	this.brand=c.brand;
	this.year=c.year;
	this.price=c.price;
}
public long getSerialNum() 
{
	return this.serialNum;
}
public String getBrand() 
{
	return this.brand;
}
public int getYear() 
{
	return this.year;
}
public double getPrice() 
{
	return this.price;
}
public void setSerialNum(long SerialNum) 
{
	this.serialNum=SerialNum;
}
public void setBrand(String brand) 
{
	this.brand=brand;
}
public void setYear(int year) 
{
	this.year=year;
}
public void setPrice(double price) 
{
	this.price=price;
}
public CellPhone clone() 
{
	return new CellPhone(this);
}
public String toString() 
{
	return ("["+this.serialNum+": "+this.brand+" "+this.price+"$ "+this.year+"] --->");
}
public boolean equals (Object obj) 
{
	if (obj==null) 
	{
		return false;
	}
	if (getClass()!=obj.getClass())
	{
		return false;
	}
	else 
	{
		CellPhone otherPhone=(CellPhone)obj;
		return ((this.brand.equals(otherPhone.brand)&&(this.year==otherPhone.year)&&(this.price==otherPhone.price)));
	}
}
}
