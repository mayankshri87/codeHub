package maxDiffereneBetweenNodeAndAncestor;

/*
 * 
 * Maximum difference between node and its ancestor in Binary Tree
 *    	  8
 		/  \
        3    10
       / \     \
      1   6     14
          / \   /
         4   7  13
         
         
We can have various ancestor-node difference, some of which are given below :
8 – 3 = 5
3 – 7 = -4
8 – 1 = 7
10 – 13 = -3

But among all those differences maximum value is 7 obtained by subtracting 1 from 8, which we need to return as result.
 * */

class Node{
	int data;
	Node leftChild;
	Node rightChild;
	
	Node(int data)
	{
		this.data = data;
		leftChild = null;
		rightChild = null;
	}
}
public class MaxDiffereneBetweenNodeAndAncestor {
	
	Node root;
	static int maximumDifference = Integer.MIN_VALUE;
	
	
	public int findMaxiumDifference(Node node){
		
		//Base Condition - if the node is null then return the maximum value
		if(node == null)
		{
			return Integer.MAX_VALUE;
		}
		/*Base Condition - If the left child of the node is null and right child of the node is also null, 
		 * then its a leaf node just return the data in the node*/
		if(node.leftChild==null && node.rightChild==null)
		{
			return node.data;
		}
		
		//return the minimum value from the node's left sub tress and right sub tree. By the calling the same function recursively
		int value = Math.min(findMaxiumDifference(node.leftChild), findMaxiumDifference(node.rightChild));
		
		//Keep on update the maximum Difference between the node and its ancestor
		maximumDifference = Math.max(maximumDifference, node.data-value);
		
		//return minimum, if the minimum of the left subtree and right subtree is greater than the node itself then return the node.
		return Math.min(node.data, value);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxDiffereneBetweenNodeAndAncestor tree = new MaxDiffereneBetweenNodeAndAncestor();
		
		 	tree.root = new Node(8);
	        tree.root.leftChild = new Node(3);
	        tree.root.leftChild.leftChild = new Node(1);
	        tree.root.leftChild.rightChild = new Node(6);
	        tree.root.leftChild.rightChild.leftChild = new Node(4);
	        tree.root.leftChild.rightChild.rightChild = new Node(7);
	  
	        tree.root.rightChild = new Node(10);
	        tree.root.rightChild.rightChild = new Node(14);
	        tree.root.rightChild.rightChild.leftChild = new Node(13);
	        
	        tree.findMaxiumDifference(tree.root);
	        
	        System.out.println(maximumDifference);
	}

}
