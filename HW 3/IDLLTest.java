// Romil Vimalbhai Shah
// 20008692
// CS 570 B
// Homework 3 Due on 6th March 2022

package HW3;

public class IDLLTest {

	public static void main(String[] args) 
	{
		System.out.println("\n\n" + "Romil V. Shah - Homework 3" + "\n\n");
		
        // Creating an empty indexed double linked list, data type is Integer
        IDLList<Integer> ilst = new IDLList<Integer>();

        // add element 13 at the head and now 13 becomes first Element .
        ilst.add(13);
        System.out.println("First Element in the List:" + ilst.toString());

        // add element 7 at the head now 8 Becomes the first Element
        ilst.add(0,7);
        System.out.println("Now, we add Number 7 at the Head:" + ilst.toString());

        // Adding  element 4 at index position 1
        ilst.add(1,4);
        System.out.println("Now, we add Number 4 at the Index Pos 1:" + ilst.toString());

        // Append element 21 at the end of the List
        ilst.append(21);
        System.out.println("Now, we append Number 21 in the list:" + ilst.toString() + "\n");

        // returns the object at position index 0 from the head
        System.out.println("The Current List:" + ilst.toString());
        System.out.println("Now, we get the element at 1st Index Pos: " + ilst.get(1) + "\n");

        // return the object at the head
        System.out.println("The Current List:" + ilst.toString());
        System.out.println("Now, we get the element at Head: " + ilst.getHead() + "\n");

        // return the object at the tail
        System.out.println("The Current List:" + ilst.toString());
        System.out.println("Now, we get the element at Tail: " + ilst.getLast() + "\n");

        // return the list size
        System.out.println("The Current List:" + ilst.toString());
        System.out.println("The Current List Size is: " + ilst.size() + "\n");

        // remove and return element at the head
        System.out.println("Current List is:" + ilst.toString());
        System.out.println("The Head Element we remove: " + ilst.remove());
        System.out.println("After Removing Head, the Updated  list is: " + ilst.toString() + "\n");

        // remove and return the element at the tail
        System.out.println("Current List is:" + ilst.toString());
        System.out.println("The Tail Element we remove: " + ilst.removeLast());
        System.out.println("After Removing Tail, the Updated List is: " + ilst.toString() + "\n");

        ilst.append(12);
        System.out.println("Now, we append Number 12 in the list:" + ilst.toString());
        System.out.println("Current List is : " + ilst.toString()+"\n");
        
        ilst.add(2, 34);
        System.out.println("Now, we add Number 34 at the Index Pos 2:" + ilst.toString());
        System.out.println("Current List is: " + ilst.toString()+"\n");
    
        
        System.out.println("Now, We remove the 1st Element: " + ilst.remove());
        System.out.println("Current List is: " + ilst.toString());
    }
}