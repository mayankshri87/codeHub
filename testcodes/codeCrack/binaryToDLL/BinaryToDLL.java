package binaryToDLL;

class Node{
	int data;
	Node prev;
	Node next;
	
	Node(int data){
		this.data = data;
		prev=null;
		next=null;
	}
}
public class BinaryToDLL {
	
	Node head;
	Node root;
	
	
	public void convertBinaryToDoublyLinkedList(Node node){
		if(node==null)
		{
			return;
		}
		convertBinaryToDoublyLinkedList(node.prev);
		
		if(head==null){
			head = new Node(node.data);
		}else{
			Node new_node = new Node(node.data);
			new_node.next = head;
			new_node.prev = head.prev;
			head = new_node;
		}
		
		convertBinaryToDoublyLinkedList(node.next);

	}

	void printDLL(Node head)
	{
		Node temp = head;
		while(temp!=null)
		{
			System.out.print(temp.data + " ");
			temp=temp.next;
		}
			
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BinaryToDLL tree = new BinaryToDLL();
		 	tree.root = new Node(5);
	        tree.root.prev = new Node(3);
	        tree.root.next = new Node(6);
	        tree.root.prev.next = new Node(4);
	        tree.root.prev.prev = new Node(1);
	        tree.root.next.next = new Node(8);
	        tree.root.prev.prev.next = new Node(2);
	        tree.root.prev.prev.prev = new Node(0);
	        tree.root.next.next.prev = new Node(7);
	        tree.root.next.next.next = new Node(9);
	        
	        tree.convertBinaryToDoublyLinkedList(tree.root);
	        tree.printDLL(tree.head);
	}

}
