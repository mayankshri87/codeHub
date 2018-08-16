package printLeftmostAndRightmostOfBTree;

/*
 * 		 15
        /  \
      10    20
     /  \   /  \
    8   12  16   25 

 * output should be -  15 10 20 8 25
 * 
 * The idea is to use Level Order Traversal. 
 * To find first node, we use a variable isFirst. 
 * To separate levels, we enqueue NULL after every level. So in level order traversal, 
 * if we see a NULL, we know next node would be first node of its level and therefore we set isFirst.

A special case to consider is, a tree like below.

   1
    \
     2
      \
       3
The output for above tree should be 1, 2, 3. 
We need make sure that the levels having only one node are handled and the node is printed only once. 
For this purpose, we maintain a separate variable isOne.
 * */
import java.util.LinkedList;
import java.util.Queue;


class Node{
	int data;
	Node left;
	Node right;
	
	Node(int data){
		this.data = data;
		this.left = this.right = null;
	}
}
public class PrintLeftmostAndRightMostOfBTree {

	Node root;
	
	public void printCorners(Node node){
		//Case if the node is null then return
		if(node==null){
			return;
		}
		//queue data structure to keep track of the node start with root node
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(node);
		//adding null to the queue at the end of the level to keep track of the level.
		queue.add(null);
		
		//isFirst is the flag to identify if the node is the first node of the level.
		boolean isFirst = false;
		//if isOne==true that mean level has only one node.
		boolean isOne = false;
		
		int last = 0;
		
		//loop through the queue till it is empty
		while(!queue.isEmpty()){
		
			//getting the head of the tree.
			Node temp = queue.peek();
			//removing the head of the quque
			queue.poll();
			
			//if the node is the first node of the level then print it
			if(isFirst){
				System.out.println(temp.data + " ");
				
				//adding left and right node of the tree to the queue.
				if(temp.left!=null){
					queue.add(temp.left);
				}
				if(temp.right!=null){
					queue.add(temp.right);
				}
				//making isFirst as false, as already printed the first node the tree.
				isFirst = false;
				isOne = true;
			}else if(temp==null){ 
				// Insert new separator if there are items in queue
				if(queue.size()>1){
					queue.add(null);
				}
				 // making isFirst as true because next node will be
                // leftmost node of that level
				isFirst = true;
				
				// printing last node, only if that level
                // doesn't contain single node otherwise
                // that single node will be printed twice 
				if(!isOne){
					System.out.println(last + " ");
				}
			}else{
				
				if(temp.left!=null){
					queue.add(temp.left);
				}
				if(temp.right!=null){
					queue.add(temp.right);
				}
				// Here we are making isOne = false to signify
                // that level has more than one node
				isOne = false;
				last = temp.data;
			}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PrintLeftmostAndRightMostOfBTree tree = new PrintLeftmostAndRightMostOfBTree();
		
		 	tree.root = new Node(15);
	        tree.root.left = new Node(10);
	        tree.root.right = new Node(20);
	        tree.root.left.left = new Node(8);
	        tree.root.left.right = new Node(12);
	        tree.root.right.left = new Node(16);
	        tree.root.right.right = new Node(25);
	 
	        tree.printCorners(tree.root);

	}

}
