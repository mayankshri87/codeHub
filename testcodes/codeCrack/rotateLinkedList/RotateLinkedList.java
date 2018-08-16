package rotateLinkedList;

import java.util.concurrent.LinkedBlockingDeque;

/*Problem - Rotate linkedList, if the given linked list is 10->20->30->40->50->60 then the rotated linkdedList on node number 4 is,
 * 50->60->10->20->30->40*/

public class RotateLinkedList {

	Node head;
	
	/*LinkdeList contains the nodes so, I have created the internal class with name node which has data and next node. */
	class Node{
		int data;
		Node next;
		
		public Node(int data)
		{
			this.data = data;
			next = null;
		}
	}
	
	/*push operation for LinkedList, where push will happen at the begining of LinkedList, at push head node will point to the newly inserted Node.*/
	public void push(int data)
	{
		Node newNode = new Node(data);
		//Now next of the new node will point to the head and head will point to the new node
		newNode.next = head;
		head = newNode;
	}
	
	/*Rotation operation for linked list*/
	public void rotateLinkedList(int k)
	{
		//Condition to check whether the passed number on which rotation is needed should not equal to 0.
		if(k==0) return;
		
		//setting the current node to head to traverse the linked list.
		Node current = head;
		
		//going to the kth node(kth node which rotation is needed) of the LinkedList 
		for(int i=1;i<k;i++)
		{
			current = current.next;

		}
		
		//copying the current node to kthNode.
		Node kthNode = current;
		
		//check if the current node then return because k is outside the size of the list.
		if(current==null) return;
		
		//last node should point to the head node after the rotation. so going to the last node.
		while(current.next!=null)
		{
			current = current.next;
		}
		//Now last node is pointing to the head.
		current.next = head;
		
		//New head will be the next of KthNode.
		head = kthNode.next;
		
		//Now the kthNode is the last node of the linkedList.
		kthNode.next = null;
	}
	
	public void printLinkedList()
	{
		Node node = head;

		while(node!=null)
		{
			System.out.print("-> "+node.data);
			
			node = node.next;
		}
	}
	
	public static void main(String[] args) {
		
		RotateLinkedList linkedList = new RotateLinkedList();
		
		linkedList.push(60);
		linkedList.push(50);
		linkedList.push(40);
		linkedList.push(30);
		linkedList.push(20);
		linkedList.push(10);
		
		linkedList.rotateLinkedList(4);
		linkedList.printLinkedList();
	}

}
