// Romil Vimalbhai Shah
// 20008692
// CS 570 B
// Homework 4 Due on 27th March 2022

package Recursion_HW4;

import java.util.*;

/**
 * Class that solves maze problems with backtracking.
 * @author Koffman and Wolfgang
 **/

public class Maze implements GridColors 
{
    /** The maze */
    private TwoDimGrid maze;

    public Maze(TwoDimGrid m) 
    {
        maze = m;
    }

    /** Wrapper method. */
    public boolean findMazePath() 
    {
    	return findMazePath(0,0); // (0, 0) is the start point.    
    	//    	ArrayList<ArrayList<PairInt>> a=findAllMazePaths(0,0);
    	//    	System.out.println(a);
    	//        ArrayList<PairInt> b=findMazePathMin(0,0);
    	//        System.out.println(b);
    	//        return true;  
    }

    /**
     * Attempts to find a path through point (x, y).
     * @pre Possible path cells are in BACKGROUND color;
     *      barrier cells are in ABNORMAL color.
     * @post If a path is found, all cells on it are set to the
     *       PATH color; all cells that were visited but are
     *       not on the path are in the TEMPORARY color.
     * @param x The x-coordinate of current point
     * @param y The y-coordinate of current point
     * @return If a path through (x, y) is found, true;
     *         otherwise, false
     */

    
    // METHOD FOR PROBLEM 1
    public boolean findMazePath(int x,int y) 
    {
    	
    	if(x<0||y<0||x>=maze.getNCols()||y>=maze.getNRows()) 
    	{
    		return false; 
    	}
    	else if(!maze.getColor(x,y).equals(NON_BACKGROUND)) 
    	{
    		return false; 
    	}	
    	else if(x==maze.getNCols()-1&&y==maze.getNRows()-1) 
    	{
    			maze.recolor(x,y,PATH); 
    			return true;
    	} 
    	else 
    	{
    			maze.recolor(x,y,PATH);
    			
    			if (findMazePath(x+1,y)||findMazePath(x-1,y)||findMazePath(x,y+1)||findMazePath(x,y-1))
    			{
    				return true;
    			} 
    			else 
    			{
    				maze.recolor(x,y,TEMPORARY);
    				return false;
    			}
    	}
    }
    
    
    // METHOD FOR PROBLEM 2
    private void findMazePathStackBased(int x,int y,ArrayList<ArrayList<PairInt>> result,Stack<PairInt> trace) 
    {
    	if(x<0||y<0||x>=maze.getNCols()||y>=maze.getNRows()) 
    	{
    		
    	}
    	else if(!maze.getColor(x,y).equals(NON_BACKGROUND)) 
    	{
    		
    	}	
    	else if(x==maze.getNCols()-1&&y==maze.getNRows()-1) 
    	{
    		trace.push(new PairInt(x,y));
    		
            ArrayList<PairInt> a=new ArrayList<>(trace); 
            
            result.add(a);
            
            maze.recolor(x,y,NON_BACKGROUND);
            
            trace.pop();
    	} 
    	else 
    	{
    		 trace.push(new PairInt(x,y)); 
    		 
             maze.recolor(x,y,PATH);
             
             findMazePathStackBased(x+1,y,result,trace);
             
             findMazePathStackBased(x-1,y,result,trace);
             
             findMazePathStackBased(x,y+1,result,trace);
             
             findMazePathStackBased(x,y-1,result,trace);
             
             maze.recolor(x,y,NON_BACKGROUND);
             
             trace.pop();
    	}	
	}
    
    public ArrayList<ArrayList< PairInt >> findAllMazePaths(int x,int y) 
    {
    	ArrayList<ArrayList<PairInt>> result=new ArrayList<>();
    	
    	Stack<PairInt> trace=new Stack<>();
    	
    	findMazePathStackBased(0,0,result,trace);
    	
    	return result;
    }
    
    
   	// METHOD FOR PROBLEM 3
    public ArrayList<PairInt> findMazePathMin(int x,int y)
    {
    	int index=0;
    	 
        ArrayList<ArrayList<PairInt>> paths=findAllMazePaths(x,y);
         
        if(paths.size()==0) 
        {
        	throw new ArrayIndexOutOfBoundsException("NO PATH");
        }
         
        int min=paths.get(0).size();
         
        for(int i=1;i<paths.size();i++) 
        {
        	if(min>paths.get(i).size()) 
     		{
     			min=paths.get(i).size();
     			
     			index=i;
     		}
     	}
        
        ArrayList<PairInt> smallest=paths.get(index);
        for(int i=0;i<smallest.size();i++) 
        {
        	 maze.recolor(smallest.get(i).getX(),smallest.get(i).getY(),PATH);  
        }
        
        return smallest;
    }
    
    /*<exercise chapter="5" section="6" type="programming" number="2">*/
    public void resetTemp() 
    {
        maze.recolor(TEMPORARY, BACKGROUND);
    }
    /*</exercise>*/

    /*<exercise chapter="5" section="6" type="programming" number="3">*/
    public void restore() 
    {
        resetTemp();
        
        maze.recolor(PATH, BACKGROUND);
        
        maze.recolor(NON_BACKGROUND, BACKGROUND);
    }
    /*</exercise>*/
}
/*</listing>*/