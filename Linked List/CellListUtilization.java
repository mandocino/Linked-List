import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CellListUtilization {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner theKeyboard= new Scanner (System.in);
		Scanner sc=null;
		CellList l1= new CellList();

		try 
		{
		sc=new Scanner(new FileInputStream("Cell_Info.txt"));
		String currentLine; //the next line 
		String currentString; //
		int C=0;
		while (sc.hasNextLine()) 
		{
			CellPhone c = new CellPhone();
			C=0;
			while (C!=4) 
			{		
				currentString=sc.next();
				if(C==0)
			c.setSerialNum(Long.parseLong(currentString));
				if (C==1)
			c.setBrand(currentString);
				if (C==2)
			c.setPrice(Double.parseDouble(currentString));
				if(C==3)
			c.setYear(Integer.parseInt(currentString));
				C++;
			}
			if (!l1.contains(c.getSerialNum()))
				l1.addToStart(c);
		}
		System.out.println("The current size of the list is "+l1.getSize()+". Here are the contents of the list");
		System.out.println("----------------------------------------------------");
		System.out.println(l1.getSize());
		l1.showContents();
		
		System.out.print("Enter a serial number to search for: ");
		long serialnum=theKeyboard.nextLong();
		l1.find(serialnum);

		}
		catch (FileNotFoundException e) 
		{
			System.out.println(e.getMessage());
		}
		
		System.out.println();
		CellPhone c = new CellPhone(1,"iphone", 2018, 1);
		CellPhone c1 = new CellPhone(1,"andoir", 2018, 2);
		CellPhone c2 = new CellPhone(1,"samsung", 2018, 3);
		CellPhone c3 = new CellPhone(1,"iphoness", 2018, 4);

		CellList l2= new CellList();
		//tests the add to start method
		l2.addToStart(c1);
		l2.addToStart(c2);
		l2.showContents();
		System.out.println("The current size of the list is "+l2.getSize()+". Here are the contents of the list");

		l2.insertAtIndex(c3, 2); //c2 c3 c1
		l2.showContents();
		System.out.println("The current size of the list is "+l2.getSize()+". Here are the contents of the list");

		System.out.println();
		l2.deleteFromIndex(3);
		l2.showContents(); //removes c1
		System.out.println("The current size of the list is "+l2.getSize()+". Here are the contents of the list");

	
		System.out.println();
		l2.deleteFromStart();
		l2.showContents(); //deletes c2, leaves c3
		System.out.println("The current size of the list is "+l2.getSize()+". Here are the contents of the list");


		l2.addToStart(c1);
		l2.addToStart(c2);
		System.out.println(l2.equals(l1));
		System.out.println(l2.contains(1));
		System.out.println();
		}
	}
