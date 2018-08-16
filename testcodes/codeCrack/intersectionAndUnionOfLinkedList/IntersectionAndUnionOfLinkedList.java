package intersectionAndUnionOfLinkedList;
/*
 * Input:
   List1: 10->15->4->20
   lsit2:  8->4->2->10
Output:
   Intersection List: 4->10
   Union List: 2->8->20->4->15->10
 * 
 * Union (list1, list2)
Initialize the result list as NULL and create an empty hash table. 
Traverse both lists one by one, for each element being visited, 
look the element in hash table. 
If the element is not present, then insert the element to result list. If the element is present, then ignore it.

Intersection (list1, list2)
Initialize the result list as NULL and create an empty hash table. Traverse list1. 
For each element being visited in list1, insert the element in hash table. 
Traverse list2, for each element being visited in list2, look the element in hash table. 
If the element is present, then insert the element to result list. If the element is not present, then ignore it
*/


import java.util.HashMap;
import java.util.HashSet;

import com.sun.org.apache.bcel.internal.generic.L2D;

class Node{
	int data;
	Node next;
	
	Node(int data){
		this.data = data;
	}
}
public class IntersectionAndUnionOfLinkedList {

	Node head;
	
	public void push(int data){
		Node new_node = new Node(data);
		
		if(head == null){
			head = new_node;
		}else{
			new_node.next = head;
			head = new_node;
		}
		
	}
	
	public void append(int data){
		Node new_node = new Node(data);
		
		if(head==null){
			head=new_node;
		}else{
			Node temp = head;
			while(temp.next!=null){
				temp=temp.next;
			}
			temp.next = new_node;
		}
	}
	
	public IntersectionAndUnionOfLinkedList intersectionOfList(Node head1, Node head2){
				
		if(head1==null || head2==null){
			return null;
		}
		HashSet<Integer> hSet = new HashSet<Integer>();
		
		Node node1 = head1;
		Node node2 = head2;
		
		IntersectionAndUnionOfLinkedList resultList = new IntersectionAndUnionOfLinkedList();
		
		while(node1!=null){
			hSet.add(node1.data);
			
			node1= node1.next;
		}
		
		//For every element of list2 present in hset
	    //loop inserts the element into the result
		while(node2!=null){
			if(hSet.contains(node2.data)){
				resultList.push(node2.data);
			}
			node2=node2.next;
		}
		
		return resultList;
	}
	
	public IntersectionAndUnionOfLinkedList unionOfLinkedlist(Node head1,Node head2){
		
		 // HashMap that will store the 
	    // elements of the lists with their counts
		HashMap<Integer, Integer> hMap = new HashMap<Integer,Integer>();
		Node n1 = head1;
		Node n2 = head2;

	    // loop inserts the elements and the count of 
	    // that element of list1 into the hmap
		while(n1!=null){
			if(hMap.containsKey(n1.data)){
				int val = hMap.get(n1.data) + 1;
				hMap.put(n1.data, val);
			}else{
				hMap.put(n1.data,1);
			}
			n1=n1.next;
		}
		 
	    // loop further adds the elements of list2 with 
	    // their counts into the hmap
		while(n2!=null){
			if(hMap.containsKey(n2.data)){
				int val = hMap.get(n2.data) + 1;
				hMap.put(n2.data, val);
			}else{
				hMap.put(n2.data, 1);
			}
			n2=n2.next;
		}
		
		IntersectionAndUnionOfLinkedList resultList = new IntersectionAndUnionOfLinkedList();
		
		for(int i:hMap.keySet()){
			resultList.append(i);
		}
		
		return resultList;
	}
	 /* Utility function to print list */
    void printList()
    {
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IntersectionAndUnionOfLinkedList llist1 = new IntersectionAndUnionOfLinkedList();
		IntersectionAndUnionOfLinkedList llist2 = new IntersectionAndUnionOfLinkedList();
		IntersectionAndUnionOfLinkedList intersection = new IntersectionAndUnionOfLinkedList();
		IntersectionAndUnionOfLinkedList union = new IntersectionAndUnionOfLinkedList();
		
		
		/*create a linked list 10->15->4->20 */
        llist1.push(20);
        llist1.push(4);
        llist1.push(15);
        llist1.push(10);
 
        /*create a linked list 8->4->2->10 */
        llist2.push(10);
        llist2.push(2);
        llist2.push(4);
        llist2.push(8);
		
        
        intersection = intersection.intersectionOfList(llist1.head,llist2.head);
        union=union.unionOfLinkedlist(llist1.head, llist2.head);
        
        System.out.println("First List is");
        llist1.printList();
 
        System.out.println("Second List is");
        llist2.printList();
 
        System.out.println("Intersection List is");
        intersection.printList();
 
        System.out.println("Union List is");
        union.printList();
	}

}
