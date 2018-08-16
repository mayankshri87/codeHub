package palindromeLinkedList;

import java.util.LinkedList;
import java.util.Stack;


class Node{
	int data;
	Node next;
	
	Node(int data){
		this.data = data;
		this.next = null;
	}
}
public class PalindromeLinkedList {
	
	Node head;
	
	/*In this method we will traverse the list and store the value of the each node in stack and then tarverse again 
	 * and compare the values form stack.*/

	public boolean checkPalindrome(Node head){
		
		if(head==null){
			return false;
		}
		Stack tempStack = new java.util.Stack<Integer>();
		
		Node temp = head;
		
		while(temp!=null){
			tempStack.push(temp.data);
			temp=temp.next;
		}
		
		temp=head;
		
		while(temp!=null){
			int key = (int) tempStack.pop();
			if(temp.data!=key){
				return false;
			}
			temp=temp.next;
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromeLinkedList list = new PalindromeLinkedList();
		
		list.head = new Node(1);
		list.head.next = new Node(2);
		list.head.next.next = new Node(2);
		
		System.out.println(list.checkPalindrome(list.head));

	}

}
