package flatteningLinkedList;
/*
 * Given a linked list where every node represents a linked list and contains two pointers of its type:
(i) Pointer to next node in the main list (we call it ‘right’ pointer in below code)
(ii) Pointer to a linked list where this node is head (we call it ‘down’ pointer in below code).
All linked lists are sorted. See the following example

       5 -> 10 -> 19 -> 28
       |    |     |     |
       V    V     V     V
       7    20    22    35
       |          |     |
       V          V     V
       8          50    40
       |                |
       V                V
       30               45
Write a function flatten() to flatten the lists into a single linked list. 
The flattened linked list should also be sorted. 
For example, for the above input list, output list should be 5->7->8->10->19->20->22->28->30->35->40->45->50.
 * */
class Node{
	int data;
	Node rigtChild;
	Node downChild;
	
	Node(int data){
		this.data = data;
		this.rigtChild = null;
		this.downChild = null;
	}
}
public class FlatteningLinkedList {
	
	Node head;
	
	/*Push method to create the linked list as described in the comments at the start*/
	public Node push(Node head,int data)
	{
		Node new_node = new Node(data);
		new_node.downChild = head;
		head = new_node;
		
		return head;
		
	}
	
	/*Recursive to flatten the linked list, In this method we will keep on going to the right of the linkedlist,
	 * and then sort and merge the list with the previous list*/

	public Node flattenLinkedList(Node root)
	{
		//Base Condition - If the node is null or the right child of the node is null then return the root
		
		if(root == null || root.rigtChild == null)
		{
			return root;
		}
		//call the method recursively for flattening the right child
		
		root.rigtChild = flattenLinkedList(root.rigtChild);
		
		//Sort the rightChild of the node with current node
		
		root = sort(root, root.rigtChild);
		
		return root;
	}

	private Node sort(Node a, Node b) {
		
	//Base Conditions- 1. If the node a is null then return the node b 
		
		if(a==null)
			return b;
		
		//Base Condition - 2. If the node b is null then return a.
		if(b==null)
			return a;
		 // compare the data members of the two lonked lists
        // and put the larger one in the result
		Node result;
		if(a.data<b.data)
		{
			result = a;
			result.downChild = sort(a.downChild,b);
		}else{
			result = b;
			result.downChild = sort(a,b.downChild);
		}
		
		return result;
	}
	
	   void printList()
	    {
	        Node temp = head;
	        while (temp != null)
	        {
	            System.out.print(temp.data + " ");
	            temp = temp.downChild;
	        }
	        System.out.println();
	    }

	public static void main(String[] args) {

		FlatteningLinkedList L = new FlatteningLinkedList();
		L.head = L.push(L.head, 30);
        L.head = L.push(L.head, 8);
        L.head = L.push(L.head, 7);
        L.head = L.push(L.head, 5);
 
        L.head.rigtChild = L.push(L.head.rigtChild, 20);
        L.head.rigtChild = L.push(L.head.rigtChild, 10);
 
        L.head.rigtChild.rigtChild = L.push(L.head.rigtChild.rigtChild, 50);
        L.head.rigtChild.rigtChild = L.push(L.head.rigtChild.rigtChild, 22);
        L.head.rigtChild.rigtChild = L.push(L.head.rigtChild.rigtChild, 19);
 
        L.head.rigtChild.rigtChild.rigtChild = L.push(L.head.rigtChild.rigtChild.rigtChild, 45);
        L.head.rigtChild.rigtChild.rigtChild = L.push(L.head.rigtChild.rigtChild.rigtChild, 40);
        L.head.rigtChild.rigtChild.rigtChild = L.push(L.head.rigtChild.rigtChild.rigtChild, 35);
        L.head.rigtChild.rigtChild.rigtChild = L.push(L.head.rigtChild.rigtChild.rigtChild, 20);
        
       Node head = L.flattenLinkedList(L.head);
       L.printList();

	}

}
