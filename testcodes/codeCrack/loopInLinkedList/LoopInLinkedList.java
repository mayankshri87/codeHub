package loopInLinkedList;

import sun.dc.path.FastPathProducer;

/*
 * 1) Detect Loop using Floyd’s Cycle detection algo and get the pointer to a loop node.
2) Count the number of nodes in loop. Let the count be k.
3) Fix one pointer to the head and another to kth node from head.
4) Move both pointers at the same pace, they will meet at loop starting node.
5) Get pointer to the last node of loop and make next of it as NULL.
 * */

class Node
{
	int data;
	Node next;
	
	Node(int data)
	{
		this.data = data;
		this.next = null;
	}
	}
public class LoopInLinkedList {

	Node head;
	
	/*Floyd's cycle to detect loop when slow and fast pointer will meet at common point*/
	public int detectAndRemoveLoop(Node node)
	{
		//creating a slow pointer and a fast pointer
		Node slow = node;
		Node fast = node;
		
	
		while(slow!=null && fast!=null && fast.next!=null)
		{
			//when slow pointer move one then fast will move two times.
			slow = slow.next;
			fast = fast.next.next;
			
			//when slow pointer and the fast pointer are same that means a loop has detected
			if(slow==fast)
			{
				removeLoop(slow,node);
			}
		}
		
		return 0;
	}
	
	//Method to remove the loop
	private void removeLoop(Node slow, Node node) {
		
		Node pointer1 = slow;
		Node pointer2 = slow;
		
		int k = 0;
		//counting the number of nodes in loop
		while(pointer2.next != slow)
		{
			k++;
			pointer2 = pointer2.next;
		}
		//setting both the pointers at the head
		
		pointer1 = node;
		pointer2 = node;
		
		//setting one of the pointer at kth node and another on head and then incerment them with same speed and check if they meet at any common point
		for(int i=0;i<k;i++)
		{
			pointer2=pointer2.next;
		}
		
		//now detecting the loop and removing the loop
		while(pointer2.next!=pointer1)
		{
			pointer1=pointer1.next;
			pointer2=pointer2.next;
		}
		pointer2.next = null;
	}

	void printList(Node head)
	{
		Node pointer = head;
		while(pointer!=null)
		{
			System.err.print(" "+pointer.data);
			pointer=pointer.next;
		}
	}
	public static void main(String[] args) {
		
		LoopInLinkedList list = new LoopInLinkedList();
		
		 list.head = new Node(50);
	        list.head.next = new Node(20);
	        list.head.next.next = new Node(15);
	        list.head.next.next.next = new Node(4);
	        list.head.next.next.next.next = new Node(10);
	 
	        // Creating a loop for testing 
	        list.head.next.next.next.next.next = list.head.next.next;
	        
	        list.detectAndRemoveLoop(list.head);
	        
	        list.printList(list.head);
	}

}
