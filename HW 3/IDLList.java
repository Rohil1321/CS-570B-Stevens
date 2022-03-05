// Romil Vimalbhai Shah
// 20008692
// CS 570 B
// Homework 3 Due on 6th March 2022

package HW3;

import java.util.ArrayList;

public class IDLList<E>
{
    private static class Node<E> 
    {
        // data fields for private inner class Node<E>
        private E data;
        private Node<E> next;
        private Node<E> prev;

        // a constructor holds "elem"
        private Node(E elem) 
        {
            this.data = elem;
        }

        // a constructor that creates a node holding "elem", with "next" as Next and "prev" as previous.
        public Node(E elem, Node<E> prev, Node<E> next) 
        {
            this.data = elem;
            this.prev = prev;
            this.next = next;
        }
    }
    
    // data fields for IDLList<E>
    private Node<E> head;
    private Node<E> tail;
    private int size;
    private ArrayList<Node<E>> indices;

    // creating an Empty Doubly Link-list with head as null element and tail as null.
    public IDLList()
    {
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.indices = new ArrayList<>();
    }

    //Adding  "elem" Element at position of "index" 
    public boolean add(int index, E elem) 
    {

        // if index is out of bound of arrayList indices, then an exception will be thrown
        if (index < 0 || index >= indices.size()) 
        {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }

        if (index == 0) 
        {
            // when Index is o then adding element at head.
            add(elem);
            return true;
        } 
        else	// get h element in arrayList by using get(index)
        {
            
            Node<E> node = indices.get(index);

            // create a newElement that will be added into LinkedList
            Node<E> newElement = new Node<>(elem);

            // Inserting newElement in the Doubly-LinkList .
            newElement.next = node;
            newElement.prev = node.prev;
            node.prev.next = newElement;
            node.prev = newElement;
            size++;

            // Modifying the arrayList in term of Linklist.
            indices.add(index, newElement);

            return true;
        }
    }

    // Adding "elem" at Head and "elem" Becomes head pointer in Link List.
    public boolean add(E elem) 
    {

        if (head == null) 
        {
            head = new Node<>(elem);
            tail = head;
            size++;
            indices.add(0,head); // add the head onto O Position. 

            return true;
        } 
        else 
        {
            // if head != null, then insert "InitialN" before "head" in the list
            Node<E> InitialN = new Node<>(elem);

            InitialN.next = head;
            head.prev = InitialN;
            head = InitialN;
            size++;

            // Adding "First" onto first position 0 in indices
            indices.add(0, InitialN);

            return true;
        }
    }

    //Adding the new Element in list at end of list
    public boolean append(E elem) 
    {

        // if The head is null, head and tail all point to newly created Head
        if (head == null) 
        {
            add(elem);
            return true;
        }

        // if head is not null, then "EndN" name Node is created and its Inserted after the tail
        Node<E> EndN = new Node<>(elem);

        tail.next = EndN;
        EndN.prev = tail;
        tail = EndN;
        size++;
        indices.add(EndN);
        return true;
    }

    //Return the object at index Position where the head is 
    public E get(int index) 
    {
    	return indices.get(index).data;
    }
    
    // Return the Element from head in the List
    public E getHead () 
    {
        return head.data;
    }
  
    //Return the Element from tail in list
    public E getLast() 
    {
        return tail.data;
    }

    //Provides the Size of List     
    public int size() 
    {
        return indices.size();
    }

    //Removes the element from the head in List.
    public E remove() 
    {
        if (head == null)
        {
        	return null;
        }
        
        Node<E> DataStore = head; // head.data is stored in node DataStore

        head = head.next; // head points to the next element
        head.prev = null;
        size--;
        indices.remove(DataStore);

        return DataStore.data;
    }

    // Removes Last Element from the List and Returns The Tail. 
    public E removeLast() 
    {
        if (tail == null)
        {
        	return null;
        }
        
        Node<E> EndElement = tail;
        tail = tail.prev;
        tail.next = null;
        size--;
        indices.remove(EndElement);

        return EndElement.data;
    }

    // Removes and Return the Element from Index 
    public E removeAt(int index)
    {

        // if index is out of bound of arrayList , then an exception will be thrown.
        if (index < 0 || index >= indices.size()) 
        {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }

        if (index == 0)
        {
        	return remove();
        }
        
        if (index == indices.size() - 1) 
        {
        	return removeLast();
        }
        
        Node<E> NodeDel = indices.get(index);
        NodeDel.prev.next = NodeDel.next;
        NodeDel.next.prev = NodeDel.prev;
        size--;

        // Remove the Node in indices. 
        indices.remove(NodeDel);

        return NodeDel.data;

    }
    
    // removes the first occurrence of elem in the list and returns true. Return false if elem was not in the list
    public boolean remove(E elem) 
    {
        for (int pa = 0; pa < indices.size(); pa++) 
        {
            if (indices.get(pa).data == elem)
            {
                removeAt(pa);
                return true;
            }
        }

        return false;
    }

    public String toString() 
    {				
        Node<E> func1 = head;  // loop through the linked list and return the Element
        
        String outputdata = "";
        
        while (func1 != null) 
        {
        	outputdata += " " + func1.data.toString();
            func1 = func1.next;
        }

        return outputdata;
    }
}