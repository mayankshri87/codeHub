package levelOrderTraversal;

import java.util.Queue;
import java.util.LinkedList;


/*  
 *         1
		 /    \
		2      3
		/ \    
		4   5  
       
	  
The output of print will be:
1 2 3 4 5 6 7 8 9
*/

class Node{
	int data;
	Node leftChild;
	Node rightChild;
	
	public Node(int data)
	{
		this.data = data;
		this.leftChild = null;
		this.rightChild = null;
	}
	
}
public class LevelOrderTraversal {

	Node root;
	
	public LevelOrderTraversal(){
		this.root = null;
	}
	/*In this method we will print the node data in level order. 
	 * 1) Create an empty queue q
	 * 2) temp_node = root 
	 * 3) Loop while temp_node is not NULL
		    a) print temp_node->data.
		    b) Enqueue temp_node’s children (first left then right children) to q
		    c) Dequeue a node from q and assign it’s value to temp_node 
	 */
	public void printLevelOrderTraversal()
	{
		Queue<Node> dQueue = new LinkedList<Node>();
		
		if(root==null)
		{
			return;
		}
		dQueue.add(root);
		//Run the loop till queue is not empty.
		while(!dQueue.isEmpty()){
			
			Node tempNode = dQueue.poll();
			
			System.out.print(" "+tempNode.data);
			
			if(tempNode.leftChild != null)
			{
				dQueue.add(tempNode.leftChild);
			}
			if(tempNode.rightChild != null)
			{
				dQueue.add(tempNode.rightChild);
			}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LevelOrderTraversal tree = new LevelOrderTraversal();
		
		tree.root = new Node(1);
        tree.root.leftChild = new Node(2);
        tree.root.rightChild = new Node(3);
        tree.root.leftChild.leftChild = new Node(4);
        tree.root.leftChild.rightChild = new Node(5);
        
        tree.printLevelOrderTraversal();

	}

}
