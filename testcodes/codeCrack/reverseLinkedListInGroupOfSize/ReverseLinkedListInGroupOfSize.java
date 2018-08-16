package reverseLinkedListInGroupOfSize;

class Node{
	int data;
	Node next;
	
	Node(int data)
	{
		this.data = data;
		this.next = null;
	}
}
public class ReverseLinkedListInGroupOfSize {

	Node head;
	
	public Node reverseInGroup(Node head,int size)
	{
		
		
		Node current = head;
		Node next = null;
		Node prev = null;
		int counter=0;
		/* Reverse first k nodes of linked list */
		while(counter < size && current!=null)
		{
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			counter++;
		}
		/* next is now a pointer to (k+1)th node 
        Recursively call for the list starting from current.
        And make rest of the list as next of first node */
		if(next!=null)
		{
			head.next=reverseInGroup(next, size);
		}
		return prev;
	}
	
	// prev is now head of input list
	public void push(int data)
	{
		Node new_node = new Node(data);
		new_node.next = head;
		head = new_node;
	}
	
	public void printList()
	{
		Node temp = head;
		while(temp !=null)
		{
			System.out.print(" "+temp.data);
			temp = temp.next;
		}
		System.out.println("");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ReverseLinkedListInGroupOfSize llist = new ReverseLinkedListInGroupOfSize();
		
		/* Constructed Linked List is 1->2->3->4->5->6->
        7->8->8->9->null */
     llist.push(9);
     llist.push(8);
     llist.push(7);
     llist.push(6);
     llist.push(5);
     llist.push(4);
     llist.push(3);
     llist.push(2);
     llist.push(1);
     
     llist.printList();
     
     llist.head = llist.reverseInGroup(llist.head, 3);
     
     llist.printList();
	}

}
