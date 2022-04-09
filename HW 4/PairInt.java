// Romil Vimalbhai Shah
// 20008692
// CS 570 B
// Homework 4 Due on 27th March 2022

package Recursion_HW4;

public class PairInt 
{
	private int x;
	private int y;
	
	public PairInt(int x,int y) 
	{
		 this.x=x;
	     this.y=y;
	}
	
	public int getX() 
	{
		return x;
	}
	
	public int getY() 
	{
		return y;
	}
	
	public void setX(int x) 
	{
		this.x = x;
	}
	
	public void setY(int y) 
	{
		this.y = y;
	}
	
	@Override
	public boolean equals(Object p) 
	{
        if (p==null) 
        {
            return false;
        }
        
        PairInt pair=(PairInt) p;
        
        return (this.x==pair.x && this.y==pair.y);
	}
	
	@Override
	public String toString() 
	{
		 return "("+x+","+y+")";
	}
	
	public PairInt copy() 
	{
		return new PairInt(x,y);
	}
}