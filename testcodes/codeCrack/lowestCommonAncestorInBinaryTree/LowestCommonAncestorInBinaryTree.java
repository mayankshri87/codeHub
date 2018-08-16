package lowestCommonAncestorInBinaryTree;

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
public class LowestCommonAncestorInBinaryTree {

	Node root;
	
	public Node findLowestCommonAncentor(Node root,int data1, int data2)
	{
		if(root==null)
		{
			return null;
		}
		if(root.data==data1)
		{
			return root;
		}
		if(root.data==data2)
		{
			return root;
		}
		
		Node leftLCA = findLowestCommonAncentor(root.left, data1, data2);
		Node rightLCA = findLowestCommonAncentor(root.right, data1, data2);
		
		if(leftLCA!=null && rightLCA!=null)
		{
			return root;
		}
		if(leftLCA==null)
		{
			return rightLCA;
		}else{
			return leftLCA;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LowestCommonAncestorInBinaryTree tree = new LowestCommonAncestorInBinaryTree();
		  	tree.root = new Node(1);
	        tree.root.left = new Node(2);
	        tree.root.right = new Node(3);
	        tree.root.left.left = new Node(4);
	        tree.root.left.right = new Node(5);
	        tree.root.right.left = new Node(6);
	        tree.root.right.right = new Node(7);
	        
	        System.out.println("LAC(4,5) = "+(tree.findLowestCommonAncentor(tree.root, 4, 5)).data);
	}

}
