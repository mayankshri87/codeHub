package minimumDepthOfBinaryTree;
/*
 * Given a binary tree, find its minimum depth. The minimum depth is the number of nodes along the shortest path from root node down to the nearest leaf node.

For example, minimum height of below Binary Tree is 2.

  		 1
 		/  \
       2    3
      / \     
     4   5    
 * */
class Node{
	int data;
	Node left;
	Node right;
	
	Node(int data)
	{
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
public class MinimumDepthOfBinaryTree {

	Node root;
	
	public int findMinimumDepthOfBinaryTree(Node root)
	{
		// Corner case. Should never be hit unless the code is
        // called on root = NULL
		if (root==null)
		{
			return 0;
		}
		// Base case : Leaf Node. This accounts for height = 1.
		if(root.left == null && root.right==null)
		{
			return 1;
		}
		 // If left subtree is NULL, recur for right subtree
		if(root.left==null)
		{
			return 1+findMinimumDepthOfBinaryTree(root.right);
		}
		 // If right subtree is NULL, recur for left subtree
		if(root.right==null)
		{
			return 1+findMinimumDepthOfBinaryTree(root.left);
		}
		
		return Math.min(findMinimumDepthOfBinaryTree(root.right), findMinimumDepthOfBinaryTree(root.left))+1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumDepthOfBinaryTree tree = new MinimumDepthOfBinaryTree();
		tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        
        System.out.println(" "+tree.findMinimumDepthOfBinaryTree(tree.root));
	}

}
