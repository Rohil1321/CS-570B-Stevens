//Romil Vimalbhai Shah

import java.util.*;

public class BinaryNumber 
{
	public int data[];
	public boolean overflow;
	
//A constructor BinaryNumber is taken for getting the length of binary number and consisting only of zeros.
	
	public BinaryNumber(int length)
	{
		data=new int[length];
		for(int i=0;i<length;i++) 
		{
		  System.out.print(data[i]);
		}
	}
	
// A constructor BinaryNumber (str) is taken for creating a binary number of given string for which the corresponding binary number should be created.
	
	public BinaryNumber(String str)
	{ 
	  System.out.print('\n');
	  data=new int[str.length()];
		for(int i=0;i<str.length(); i++)
		{
			char C = str.charAt(i);
			data[i]=java.lang.Character.getNumericValue(str.charAt(i));
		}
	}

// The method getLength() is for determining the length of a binary number. 
	
	public int getLength()
	{
		return data.length;
		
	}
	
// The method getDigit(int index) is used for obtaining a digit of a binary number of given index.
	
	public int getDigit(int index) 
	{
		if(index >=data.length) 
		{	
			System.out.println("the index is out of bounds");
			return -1;
		}	
		else
			return data[index];
	}
	
// The method shiftR(int amount) is used for shifting all the digits in a binary number.
	
	 public void shiftR(int amount)
	 {
		 int shifted_data[] =new int[amount+ data.length];
		 int j=0;
		 for(int i=amount;i<shifted_data.length;i++) 
			{
			 shifted_data[i]=data[j];
			 j++;
			 
			 }
		 System.out.print("The rightshifted binary number:");
		 for(int i=0;i<shifted_data.length;i++) 
			{
			 System.out.print(shifted_data[i]);
		    }
		 data = shifted_data;
     }
	 
//Addition of two Binary Numbers.	 
	 
	 public void add(BinaryNumber aBinaryNumber)
	 {
		 if(this.getLength() != aBinaryNumber.getLength()) {
			 throw new IllegalArgumentException("Length cannot be different");
		 }
		 int fn=0;
		 int sn=0;
		 int carry=0;
		 
		 for(int i=0; i<aBinaryNumber.getLength(); i++)
		   {
			fn=this.getDigit(i);
			sn=aBinaryNumber.getDigit(i);
			if(fn==0 && sn==0)
			{
				data[i]=0+carry;
				carry=0;
			}
			else if(fn==0 && sn==1 ||  fn==1 && sn==0)
			{
				if(carry==1)
				{
					data[i]=0;
					carry=1;
				}
				else
				{
					data[i]=1;
					carry=0;
				}
			}
			else
			{
				if(carry==1)
				{
					data[i]=1;
					carry=1;
					overflow=true;
				}
				else
				{
					data[i]=0;
					carry=1;
					overflow=true;
				}
			}
		 }
		 if(carry==1) {
			 overflow=true;
			 System.out.println("Overflow");
			 }
		 else 
		 {
			 overflow=false;
		 System.out.print("The addition of a binary number is:"+toString());		  
		 }
	 }


	 
//Method toString() is used for transforming a binary number to a String.
	 
	 public String toString() 
	 {
		 if(overflow==true) 
		 {
			 return "Overflow";
		 }
		 else 
		 {
			 String st=" ";
			 for(int i=0;i<data.length;i++) 
			 {
				 st=st+data[i]; 
			 }
			 return st;
		 }  
	 }
	 
//This method toDecimal() returns the decimal number for a given binary number.
		
	public int toDecimal()
	{
		int add= 0,j=0; 
		
		for(int i = 0; i <data.length; i++)
		{
			add = (int)(add + (data[i] * Math.pow(2,j)));
			j++;
		}
		return add;
	}
	 
//This method clearOverflow() clears the overflow flag.
		 
	public void clearOverflow()
	{
		overflow=false;
	}
//The main part of program to call all the methods in the program.
	 
	public static void main(String[] args)
	{
		BinaryNumber bn= new BinaryNumber(4);
		BinaryNumber rs= new BinaryNumber("10101");
		System.out.println("The length of the binary number:"+rs.getLength());
		System.out.println("The digit of a binary number given an index:"+rs.getDigit(3));
		System.out.println("Transformation of a binary number to its decimal notation:"+rs.toDecimal());
	    rs.shiftR(2);
	    BinaryNumber rs1= new BinaryNumber("1001000"); 
	    rs.add(rs1);
	   
	}
}
