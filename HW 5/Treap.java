// Romil Vimalbhai Shah
// 20008692
// CS 570 B
// Homework 5 Due on 10th April 2022

package HW5_Treap;
/**
 * This is a Treap class to create a tree data structure that follows both the BST and the heap data structure using the node values 
 * and the heap priorities.
 * @author Romil_V._Shah - 20008692
 * @param <E>
 */

import java.util.*;

public class Treap<E extends Comparable<E>> 
{
	/**
	 * 
	 * @author Romil_V._Shah - 20008692
	 * 
	 * @param <E>
	 */
	
	private static class Node<E extends Comparable<E>>
	{
		public E data;
		
		public int priority;
		
		public Node<E> left;
		public Node<E> right;
		
		
		/**
		 * This is the node constructor. We use it to initialize all the required variables and to check if data is null.
		 * @param data
		 * @param priority
		 */
		public Node(E data,int priority) 
		{
			if(data==null)
			{
				throw new NoSuchElementException("Data is Null");
			}
			else 
			{
				this.data=data;
				this.priority=priority;
				this.left=null;
				this.right=null;
			}
		}
		
		
		/**
		 * 'rotateRight' method performs right rotation for the nodes in the tree wherever necessary.
		 * It helps maintain the order in the tree.
		 * @return
		 */
		Node<E> rotateRight()
		{
			Node<E> a=new Node<E>(this.data,this.priority);
			
			if (this.left!=null) 
			{
				if(this.right!=null) 
				{
					a.right=this.right;
				}
				if(this.left.right!=null) 
				{
					a.left=this.left.right;
				}
				
				this.priority=this.left.priority;
				this.data=this.left.data;
				this.right=a;

				if(this.left.left!=null) 
				{
					this.left=this.left.left;
				} 
				else 
				{
					this.left=null;
				}
			}
			return a;		
		}
		
		
		/**		 
		 * 'rotateLeft' method performs left rotation for the nodes in the tree wherever necessary.
		 * It helps maintain the order in the tree.
		 * @return
		 */
		Node<E> rotateLeft()
		{
			Node<E> a=new Node<E>(this.data,this.priority);
			
			if(this.right!=null) 
			{
				if(this.left!=null) 
				{
					a.left=this.left;
				}
				if(this.right.left!=null) 
				{
					a.right=this.right.left;
				}
				
				this.priority=this.right.priority;
				this.data=this.right.data;
				this.left=a;
				
				if(this.right.right!=null) 
				{
					this.right=this.right.right;
				} 
				else 
				{
					this.right=null;
				}
			}
			return a;
		}
		
		@Override
		/**
		 * 'toString' function helps override the inbuilt toString function in java so as to convert data to a string format.
		 */
		public String toString() 
		{
			return data.toString();
		}
	}
	
	private Random priorityGenerator;
	private Node<E> root;
	
	
	/**
	 * This is a constructor for the Treap class.
	 * It initializes the random priorityGenerator variable.
	 */
	public Treap() 
	{
		priorityGenerator=new Random();
		root=null;
	}
	
	
	/**
	 *This is a constructor for the Treap class.
	 * It initializes the random priorityGenerator variable with a certain seed value.
	 * @param seed
	 */
	public Treap(long seed) 
	{
		priorityGenerator=new Random(seed);
		root=null;
	}
	
	
	/**
	 * 'add' method will add the node to the tree with the given key 
	 * But, here the priority will be generated randomly.
	 * @param key
	 * @return
	 */
	public boolean add(E key)
	{
		return add(key,priorityGenerator.nextInt());	
	}
	
	
	/**
	 * 'add' method will add the node to the tree with the given key and priority values.
	 * @param key
	 * @param priority
	 * @return
	 */
	public boolean add(E key,int priority) 
	{
		Node<E> a=root;
		
		Stack<Node<E>> s=new Stack<Node<E>>();
		
		if(root==null) 
		{
			root=new Node<E>(key,priority);
			return true;
		}
		
		while(a!=null) 
		{
			s.push(a);
			if(a.data.compareTo(key)==0) 
			{
				return false;
			}
			else if(a.data.compareTo(key)<0) 
			{
				a=a.right;
			}
			else 
			{
				a=a.left;
			}
		}
		
		a=s.peek();
		
		if(a.data.compareTo(key)<0) 
		{
			Node<E> b=new Node<E>(key,priority);
			s.peek().right=b;
			s.push(b);
		}
		else 
		{
			Node<E> b=new Node<E>(key,priority);
			s.peek().left=b;
			s.push(b);
		}
		
		Node<E> b=s.pop();
		reheap(s,b);
		
		return true;
	}
	/**
	 * "reheap" function is used as a secondary help for add.
	 * It helps to maintain the heap priorities for the tree while maintaining the BST.
	 * This helps the tree become a Treap data structure.
	 * @param s
	 * @param b
	 */
	private void reheap(Stack<Node<E>> s,Node<E> b) 
	{
		Node<E> a=s.pop();
		
		while(a!=null&&a.priority<b.priority) 
		{
			if(b.data.compareTo(a.data)<0) 
			{
				a.rotateRight();
				
				if(s.isEmpty()) 
				{
					return;
				}
				
				a=s.pop();
			}
			else 
			{
				a.rotateLeft();
				
				if(s.isEmpty()) 
				{
					return;
				}
				
				a=s.pop();
			}
		}
	}
	
	
	/**
	 * 'delete' method deletes the node with the given key.
	 * It deletes the node in such a way that the Treap order is maintained.
	 * @param key
	 * @return
	 */
	public boolean delete(E key)
	{
		if(find(key)!=true) 
		{
			return false;
		}
		else 
		{
			Node<E> d=root;
			Node<E> a=null;
			
	        while(d.data.compareTo(key)!=0)
	        {
	            a=d;
	            if(d.data.compareTo(key)<0) 
	            {
	                d=d.right;
	            }
	            else 
	            {
	            	d=d.left;
	            }
	        }
	        
	        while(!(d.left==null&&d.right==null)) 
	        {
	        	a=d;
	        	
	        	if(d.right==null) 
	        	{
	        		d=d.rotateRight();	        	
	        	}
	        	else if(d.left==null) 
	        	{
	        		d=d.rotateLeft();
	        	}
	        	else if(d.left.priority<d.right.priority) 
	        	{
	        		d=d.rotateLeft();
	        	}
	        	else 
	        	{
	        		d=d.rotateRight();
	        	}
	        }
	        
	        if(root.data.compareTo(key)==0&&root.right==null&&root.left==null) 
	        {
	        	root=null;
	        }
	        else if(a.right!=null&&a.right.data.compareTo(key)==0) 
	        {
	        	a.right=null;
	        }
	        else 
	        {
	        	a.left=null;
	        }
	        
	        return true;
		}
	}
	
	
	/**
	 * 'find' function helps to find the node with the given key value.
	 * @param key
	 * @return
	 */
	public boolean find(E key) 
	{
		if(key==null)
		{
			throw new NoSuchElementException("Key is Null");
		}
		
		return find(root,key);
	}
	
	
	/**
	 * 'find' function helps find the node with the provided key and root values.
	 * If the node is found it returns true, if the node isn't found, it returns false. 
	 * @param root
	 * @param key
	 * @return
	 */
	private boolean find(Node<E> root,E key) 
	{
		if(root==null)
		{
			return false;
		}
		else if(key.compareTo(root.data)==0) 
		{
			return true;
		}
		else if(key.compareTo(root.data)<0) 
		{
			return find(root.left, key);
		}
		else 
		{
			return find(root.right,key);
		}
	}
	
	
	/**
	 * 'toString' method is used here to override the inbuilt toString function so that we can print the tree as a string.
	 */
	public String toString() 
	{
		StringBuilder sb = new StringBuilder();
		
		preOrderTraverse(root,1,sb);
		
		return sb.toString();
	}
	
	
	/**
	 * 'preOrderTraverse' helps the toString method to traverse the tree in pre-order traversal manner.
	 * Here the root is traversed first, then the left node, after that the right node.
	 * @param currentNode
	 * @param depth
	 * @param sb
	 */
	public void preOrderTraverse(Node<E> currentNode, int depth, StringBuilder sb) 
	{
		for(int i=1;i<depth;i++) 
		{
			sb.append(" ");
		}
		
		if(currentNode==null) 
		{
			sb.append("Null \n");
		}
		else 
		{
			sb.append("(The Key = " + currentNode.toString() + ", Its Priority = " + currentNode.priority + ")\n");
			
			preOrderTraverse(currentNode.left,depth+1,sb);
			preOrderTraverse(currentNode.right,depth+1,sb);
		}
	}
	
	
	/**
	 * This is the main method. We use it to check if the above methods are working or not.
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Treap<Integer> testTree = new Treap<Integer>();
		 
		// This is the structure given in Assignment.
		
		testTree.add(4,19);
		testTree.add(2,31);
		testTree.add(6,70);
		testTree.add(1,84);
		testTree.add(3,12);
		testTree.add(5,83);
		testTree.add(7,26);
		
		System.out.println("The Tree ===> \n\n" + testTree.toString());
		
		System.out.println("\n\nFinding if Element Exists at Key 7. ==> " + testTree.find(7)); 
		// Searching if any element is present at the given Key
		
		System.out.println("\nDeleting if Element Exists at Key 2. ==> " + testTree.delete(2));
		// Performing a delete operation if element exists at the given Key
		
		System.out.println("\nDeleting if Element Exists at Key 5. ==> " + testTree.delete(5) + "\n\n");
		// Performing a delete operation if element exists at the given Key
		
		System.out.println("The Tree after the changes ===> \n\n" + testTree.toString());
	}
}