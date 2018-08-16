package addingNumberRepresentedByLinkedList;

/*
 * Input:
  First List: 5->6->3  // represents number 365
  Second List: 8->4->2 //  represents number 248
Output
  Resultant list: 3->1->6  // represents number 613
 * */
class Node{
	int data;
	Node next;
	
	Node(int data)
	{
		this.data = data;
		this.next = null;
	}
}
public class AddingNumberRepresentedByLinkedList {

	Node head1,head2;
	
	/* Adds contents of two linked lists and return the head node of resultant list */
	public Node addLists(Node first,Node second){
		
		int sum =0;
		int carry = 0;
		Node result = null; // result is head node of the resultant list
		Node prev = null;
		
		while(first!=null || second!=null)
		{
			 // Calculate value of next digit in resultant list.
            // The next digit is sum of following things
            // (i)  Carry
            // (ii) Next digit of first list (if there is a next digit)
            // (ii) Next digit of second list (if there is a next digit)
			sum = carry + (first!=null?first.data:0) + (second!=null?second.data:0);
			
			 // update carry for next calulation
			carry = (sum>10)?1:0;
			// update sum if it is greater than 10
			sum = sum%10;
			// Create a new node with sum as data
			Node temp = new Node(sum);
			
			// if this is the first node then set it as head of
            // the resultant list
			if(result==null)
			{
				// If this is not the first node then connect it to the rest.
				result = temp;
			}else{
				prev.next = temp;
			}
			 // Set prev for next insertion
			prev = temp;
			// Move first and second pointers to next nodes
			if(first !=null){
				first = first.next;
			}
			if(second!=null){
				second = second.next;
			}
		}
		// return head of the resultant list
		if(carry>0)
		{
			prev.next = new Node(carry);
			
		}
		// return head of the resultant list
		return result;
	}
	
	void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println("");
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AddingNumberRepresentedByLinkedList list = new AddingNumberRepresentedByLinkedList();
	     // creating first list
        list.head1 = new Node(7);
        list.head1.next = new Node(5);
        list.head1.next.next = new Node(9);
        list.head1.next.next.next = new Node(4);
        list.head1.next.next.next.next = new Node(6);
        System.out.print("First List is ");
        
	}

}
