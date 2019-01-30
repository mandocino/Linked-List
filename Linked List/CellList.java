import java.lang.Exception;
import java.util.NoSuchElementException;;
/**
 * The CellList class creating the linkedlist. Also contains an inner class class called CellNode.
 * @author Armando Mancino 40078466
 *
 */
public class CellList {

	private CellNode h;
	private int size;
	public CellList() {
		h=null;
		size=0;
	}
	/**
	 * Copy constructor
	 * @param c
	 */
	public CellList (CellList c) 
	{
		this.h=c.h;
		this.size=c.size;
	}
	/**
	 * Inner Class called CellNode for the linked list.
	 * @author Armando Mancino (40078466)
	 */
		public class CellNode
		{
			private CellPhone phone;
			private CellNode next;
			//
			/**
			 * Default constructor 
			 */
			public CellNode() 
			{
				this.phone=null;
				this.next=null;
			}
			/**
			 * 
			 * @param cp CellPhone object
			 * @param cn next CellNode
			 */
			public CellNode(CellPhone cp, CellNode cn) 
			{
				this.phone=cp;
				this.next=cn;
			}
			/**
			 * Parameterized Constructor
			 * @param cn CellNode object
			 */
			public CellNode (CellNode cn) 
			{
				this.phone=cn.phone;
				this.next=cn.next;
			}
			/**
			 * Cloning method.
			 */
			public CellNode clone() 
			{
				return new CellNode(this);
			}
			public void setPhone(CellPhone cp) 
			{
				this.phone=cp;
			}
			public void setNode(CellNode cn) 
			{
				this.next=cn;
			}
			public CellPhone getPhone() 
			{
				return this.phone;
			}
			public CellNode getNode() 
			{
				return this.next;
			}
			//
	}
	public int getSize() 
	{
		return this.size;
	}
	/**
	 * 
	 * @param c
	 * @return
	 */
	public boolean addToStart(CellPhone c) 
	{
		if (h==null)
		{
		h=new CellNode(c,null);
		this.size++;
		return true;
		}
		else
		{
			CellNode t=h;
			h=new CellNode(c.clone(),t);
			this.size++;
			return true;
		}
	}
		
	public boolean insertAtIndex(CellPhone c, int x) 
	{
	try 
	{
		if (x<=0&& x>this.size-1) 
		{
			throw new NoSuchElementException();
		}
		else 
		{
			if (h==null)
				return false;
			CellNode t = h;
			CellNode t1=t.next;
			int C=1;
			while (C+1<x) 
			{
				t=t.next;
				t1=t1.next;
				C++;
			}
			CellNode n = new CellNode (c.clone(),t1);
			this.size++;
			t.next=n;
			return true;
		}
	}
	catch (NoSuchElementException e)
	{
		System.out.println(e.getMessage());
		System.exit(0);
	}
	return false;
	}
	public boolean replaceAtIndex(CellPhone c, int x) 
	{
		try 
		{
			if (x<=0 && x>this.size-1) 
			{
				throw new NoSuchElementException();
			}
			int C=1;
			CellNode t=h;
			while (C<x) 
			{
				t=t.next;
				C++;
			}
			if (t.next==null) 
			{
			CellNode n= new CellNode(c.clone(), null);
			t.next=n;
			return true;
			}
			else 
			{
				CellNode n = new CellNode(c.clone(),t.next);
				t=n;
				return true;
			}
		}
		catch (NoSuchElementException e) 
		{
			return false;
		}
	}
	public void showContents() 
	{
		CellNode t=h;
		while (t!=null) 
		{
			System.out.println(t.phone.toString());
			t=t.next;
		}
	}
	public boolean deleteFromIndex(int x) 
	{
	if (h==null)	
		return false;
	CellNode t=h;
	int C=1;
	while (C+1<x) 
	{
		t=t.next;
		C++;
	}
	t.next=t.next.next;
	this.size--;
	return true;
	}
	public void deleteFromStart() 
	{
		if (h!=null) 
		{
			h=h.next;
		}
		this.size--;
	}
	public CellNode find(long num) 
	{
		int iterations=1;
		CellNode t=h;
		while (t!=null && t.phone.getSerialNum()!=num) 
		{
			t=t.next;
			iterations++;
		}
		if (iterations<=this.size)
		System.out.println("It took "+iterations+" iterations.");
		else 
			System.out.println("Error! Unable to be found!");
		return t;
	}
	public boolean contains(long num) 
	{
		CellNode t=h;
		while (t!=null && t.phone.getSerialNum()!=num) 
		{
			t=t.next;
		}
		if (t==null)
			return false;
		else
			return true;
	}
	public boolean equals(CellList list) 
	{
		if (list==null)
			return false;
		if (this.getClass()!=list.getClass())
			return false;
		CellList other = (CellList) list;
		if (this.size!=list.size)
			return false;
		CellNode t=h;
		CellNode t2=other.h;
		int check=0;
		for (int C=0; C<list.size; C++) 
		{
				if (t.phone.equals(t2.phone))
				{
					check++;
					t=t.next;
					t2=t2.next;
				}
		}
		if (check==this.size)
		return true;
		else
		return false;
	}
	
}
