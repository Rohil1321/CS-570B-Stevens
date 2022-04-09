// Romil Vimalbhai Shah
// 20008692
// CS 570 B
// Homework 6 Due on 1st May 2022

package HW6_Anagrams;

/**
 * An  anagram  is  word  or  phrase  formed  by  rearranging  the  letters  of  a  different word or phrase,
 * typically using all the original letters exactly once.
 * @author Romil_V._Shah - 20008692
 */
import java.io.*;
import java.util.*;

/**
 * The class Anagrams has the required functions for the program to function.
 * It satisfies all the requirements.
 * @author Romil_V._Shah - 20008692
 */
public class Anagrams 
{
	Map<Character,Integer> letterTable;
	Map<Long,ArrayList<String>> anagramTable;

	final Integer[] primenum= 
	{
			2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101
	};
	
	
	/**
	 * This is a constructor for the class Anagrams.
	 * It helps to initialize the buildLetterTable and anagramTable.
	 */
	public Anagrams() 
	{
		buildLetterTable();
		anagramTable=new HashMap<Long,ArrayList<String>>();
	}
	
	
	/**
	 * This function helps to create key and value pairs for the letterTable.
	 */ 
	private void buildLetterTable() 
	{
		Character[] alphabets= 
		{
				'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'
		};
		
		letterTable=new HashMap<Character,Integer>();
		
		for(int i=0;i<26;i++) 
		{
			letterTable.put(alphabets[i],primenum[i]);
		}
	}
	
	
	/**
	 * This helps add the word to the anagramTable.
	 * @param s
	 */
	private void addWord(String s) 
	{
		ArrayList<String> a=new ArrayList<String>();
		
		if(s==null) 
		{
			throw new NullPointerException("String is empty");
		}
		
		if(anagramTable.get(myHashCode(s))!=null) 
		{
			anagramTable.get(myHashCode(s)).add(s);
		}
		else 
		{
			a.add(s);
			anagramTable.put(myHashCode(s),a);
		}
	}
	
	
	/**
	 * This creates the hash code for all the words and has the same hash code for the anagram words
	 * @param s
	 * @return k
	 */
	private Long myHashCode(String s) 
	{
		if(s==null) 
		{
			throw new NullPointerException("The String is Empty");
		}
		
		long ln = 1;
		
		for(int i = 0; i < s.length(); i++) 
		{
			Character ch = s.toLowerCase().charAt(i);
			ln = ln * letterTable.get(ch);
		}
		return ln;
	}
	
	
	/**
	 * This helps read the file and the text in it.
	 * @param s
	 * @throws IOException
	 */
	public void processFile(String s) throws IOException 
	{
		FileInputStream fstream=new FileInputStream(s);
		
		BufferedReader br=new BufferedReader(new InputStreamReader(fstream));
		
		String strLine;
		
		while((strLine=br.readLine())!=null) 
		{
			this.addWord(strLine);
		}
		
		br.close();
	}
	
	
	/**
	 * This function gets the entry of the most number of anagrams with their key and value pair.
	 * @return a
	 */
	private ArrayList<Map.Entry<Long,ArrayList<String>>> getMaxEntries() 
	{
		ArrayList<Map.Entry<Long,ArrayList<String>>> a=new ArrayList<Map.Entry<Long,ArrayList<String>>>();
		
		int max=0;
		
		for(Map.Entry<Long,ArrayList<String>> e:anagramTable.entrySet()) 
		{
			if(e.getValue().size()==max) 
			{
				a.add(e);
			} 
			else if(e.getValue().size()>max) 
			{
				a.clear();
				
				a.add(e);
				
				max=e.getValue().size();
			}
		}
		
		return a;
	}
	
	
	/**
	 * This method helps to test the code in class Anagrams. 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Anagrams a = new Anagrams();
		
		final long startTime = System.nanoTime();
		
		try 
		{
			a.processFile("words_alpha.txt");
		} 
		catch(IOException e1) 
		{
			e1.printStackTrace();
		}
		
		ArrayList<Map.Entry<Long,ArrayList<String>>> maxEntries=a.getMaxEntries();
		
		final long estimatedTime = System.nanoTime() - startTime;
		
		final double seconds = ((double)estimatedTime / 1000000000);
		
		System.out.println("Elapsed Time: " + seconds);
		
		System.out.println("\nKey of max anagrams: " + maxEntries.get(0).getKey());
		
		System.out.println("\nList of max anagrams: \n" + maxEntries.get(0).getValue()); 
		
		System.out.println("\nLength of list of max anagrams: " + maxEntries.get(0).getValue().size());
	}
}

