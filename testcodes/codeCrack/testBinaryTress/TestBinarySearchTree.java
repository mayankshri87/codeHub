package testBinaryTress;

/* Returns true if the given tree is a binary search tree 
 (efficient version).  
int isBST(struct node* node) 
{ 
  return(isBSTUtil(node, INT_MIN, INT_MAX)); 
} 

Returns true if the given tree is a BST and its 
 values are >= min and <= max. 
int isBSTUtil(struct node* node, int min, int max) */

class Node{
	int data;
	Node leftChild;
	Node rightChild;
	
	Node(int data)
	{
		this.data = data;
		this.leftChild = null;
		this.rightChild = null;
	}
	
}
public class TestBinarySearchTree {
	Node root;
	static int maximumValue = Integer.MAX_VALUE;
	static int minimumValue = Integer.MIN_VALUE;
	public boolean checkIfTreeIsBinarySearchTree(Node node)
	{
		return isBST(node, minimumValue, maximumValue);
	}
	
	public boolean isBST(Node node,int min, int max)
	{
		if(node==null)
		{
			return true;
		}
		//for tree to be BST its node should not breach min and max constraints
		if(node.data<min || node.data>max)
		{
			return false;
		}
		
		//check recursively for the left and right child
		return isBST(node.leftChild,min,node.data-1) && isBST(node.rightChild, node.data+1, max);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestBinarySearchTree tree = new TestBinarySearchTree();
        tree.root = new Node(4);
        tree.root.leftChild = new Node(2);
        tree.root.rightChild = new Node(5);
        tree.root.leftChild.leftChild = new Node(1);
        tree.root.leftChild.rightChild = new Node(3);
 
        if (tree.checkIfTreeIsBinarySearchTree(tree.root))
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");
    }
}
