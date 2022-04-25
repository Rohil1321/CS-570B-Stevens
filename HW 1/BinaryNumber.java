//Romil Vimalbhai Shah
//20008692
//CS 570 B
//Homework 1 

package BN_HW1;

import java.util.Arrays;

public class BinaryNumber 
{
	private int data[];
	private boolean overflow;
	
	// Here for the given length the constructor stores a binary number filled with 0's in the data array
	public BinaryNumber(int length) 
	{
		data= new int [length];
		
		for(int i=0; i<length; i++)
		{   
			data[i]=0;
		}
	}
	
	
	// The input given in the string format is converted to the numeric value and stored in the data array
	public BinaryNumber(String str) 
	{
		data=new int [str.length()];
		
		for (int i = 0; i < str.length(); i++) 
		{
            char ch = str.charAt(i);
            data[i]= Character.getNumericValue(ch);
        }
 
	}
	
	
	// This method is used to get the length of the data array	
	public int getLength() 
	{
		int length=data.length;
		return length;
	}
	
	
	// Here the length of the data array is first checked and then if it is out of bounds
	// the message is printed otherwise the digit at the given index is returned
	public int getDigit(int index) 
	{
		if (index < 0 || index >= data.length) 
		{
		    System.out.println("The index which is out of bounds is:");
		    return index;
		}
		else 
		{
			int digit = data[index];
			return digit;
		}
		
	}
	
	
	// Here another array is taken to reallocate the data array and create space for the new elements to be added and 
	// the the nested for loop is used to rotate the array by the amount that is given
	public void shitfR(int amount) 
	{
		int reallocate[]=Arrays.copyOf(data,amount+data.length);
		
		int temp,last;
		
		for(int i=0; i<amount; i++) 
		{
			//System.arraycopy(reallocate, i, reallocate, i+1, reallocate.length-i-1); 
			// This can be used instead of the nested for loops
			
			last = reallocate[reallocate.length-1];
	        
			for (int j = 0; j < reallocate.length; j++) 
			{
				temp = reallocate[j];
				
	            reallocate[j] = last;
	            
	            last = temp;
	        }
		} 
		data=reallocate;
		
		System.out.println(Arrays.toString(data));
	}
	
	
	// This method adds the 2 binary numbers, before adding the 2 numbers it checks if they are of the same length. 
	// If they are not it prints the message or else it will add the 2 binary numbers and 
	// store the result in the data array of the calling object
	public void add(BinaryNumber aBinaryNumber) 
	{
		int carry=0;
		
		if (data.length != aBinaryNumber.data.length) 
		{
			System.out.println("Length is not Equal");
		}
		else 
		{
			for(int i=0; i<data.length; i++) 
			{
				int sum=data[i]+aBinaryNumber.data[i]+carry;
				
				if (sum == 1) 
				{
					data[i]=sum;
					carry=0;
					overflow=false;
				}
				else if (sum==2) 
				{
					data[i]=0;
					carry=1;
					overflow = true;
				}
				else if (sum==3) 
				{
					data[i]=1;
					carry=1;
					overflow = true;
				}
				else 
				{
					data[i]=sum+carry;
				}
			}
		}
	}
	
	
	// If the overflow condition is reached while adding the binary numbers the overflow  string is printed as overflow will be true, 
	// otherwise it will return the data array which stores the result of the binary addition
	public String toString() 
	{
		if(overflow == true) 
		{
			return "Overflow";
		}
		else 
		{
			String value = "";
			
			for(int i:data) 
			{
					value = value + i + ' ';
			}
			return value;
			//return Arrays.toString(data);
		}
	}
	
	
	//It takes the binary number stored in the data array and converts it to the decimal equivalent number using the given sum formula
	public int toDecimal() 
	{
		int sum = 0;
		
		for (int i = 0; i < data.length; i++) 
		{
			sum = (int) ((Math.pow(2, i) * data[i]) + sum);
		}
		
		return sum;
	}
	
	//This method is used to clear the boolean value in the overflow variable
	public void clearOverflow() 
	{
		overflow=false;
	}
	
	
	public static void main(String[] args) 
	{
		BinaryNumber b1 = new BinaryNumber("01110");
		BinaryNumber b2 = new BinaryNumber("11110"); 
		
		System.out.println("The 1st Binary Number is ===> " + b1);
		
		System.out.println("The 2nd Binary Number is ===> " + b2);
		
		System.out.println("\nBinary Number ' " + b1 + "' in Decimals ===> " + b1.toDecimal());
		System.out.println("Binary Number ' " + b2 + "' in Decimals ===> " + b2.toDecimal());
		
		System.out.println("\nLength of Binary Number ' " + b1 + "' ===> " + b1.getLength());
		
		System.out.println("\nThe 3rd Digit in Binary Number' " + b1 + "' is ===> " + b1.getDigit(3));
		
		System.out.println("\nAdding 2nd Binary Number ' " + b2 + "' into the 1st Binary Number ' " + b1 + "'");
		b1.add(b2);
		
		System.out.println("The 1st Binary Number after addition is ===> " + b1);
		
		System.out.println("\nThe Binary Number ' " + b1 + "' after shifting 6 digits to the rigit ===> ");
		b1.shitfR(6);
		
		System.out.println("\nThe 1st Binary Number after shiftR Operation is ===> " + b1);
	}
}