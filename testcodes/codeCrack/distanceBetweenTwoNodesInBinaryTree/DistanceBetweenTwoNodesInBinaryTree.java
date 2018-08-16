package distanceBetweenTwoNodesInBinaryTree;
/*
 * Find the distance between two keys in a binary tree, no parent pointers are given. 
 * Distance between two nodes is the minimum number of edges to be traversed to reach one node from other.
 *  	 1
 		/  \
        2    3
       / \   /  \
      4   5  6   7	
              \
              8
              
      Dist(4,5) = 2
      Dist(4,6) = 4        
           * */

class Node{
	int data;
	Node leftChild;
	Node rightChild;
	
	Node(int data){
		this.data = data;
		this.leftChild = null;
		this.rightChild = null;
	}
}
public class DistanceBetweenTwoNodesInBinaryTree {
	Node root;

	//distance betwen two nodes
	static int distance;
	//d1 and d2 is the distance of node1 and node2 from ancestor. 
	static int d1 = -1;
	static int d2 = -1;
	
	public Node findLCA(Node node,int n1, int n2, int level)
	{
		if(node==null)
		{
			return null;
		}
		if(node.data == n1)
		{
			d1 = level;
			return node;
		}
		if(node.data==n2)
		{
			d2 = level;
			return node;
		}
		
		Node leftLCA = findLCA(node.leftChild,n1,n2,level+1);
		Node rightLCA = findLCA(node.rightChild,n1,n2,level+1);
		
		if(leftLCA!=null && rightLCA!=null)
		{
			distance = d1+d2 - 2*level;
			return node;
		}
		if(leftLCA!=null)
		{
			return leftLCA;
		}else{
			return rightLCA;
		}
	}
	
	public int findDistance(Node root,int n1,int n2){
		if(root==null)
		{
			return -1;
		}
		
		Node lca = findLCA(root,n1,n2,1);
		System.out.println(lca.data);
		
		if(d1!=-1 && d2!=-1){
			return distance;
		}
		
		if(d1!=-1)
		{
			int level = findLevel(root,lca,0);
			return level;
		}
		
		if(d2!=-1)
		{
			int level = findLevel(root,lca,0);
			return level;
		}
		
		return -1;
	}
	private int findLevel(Node root, Node lca, int i) {
		if(root==null)
		{
			return 0;
		}
		if(root.data==lca.data)
		{
			return i;
		}
		
		int level = findLevel(root.leftChild, lca, i+1);
		return (level!=-1)?level:findLevel(root.rightChild, lca, i+1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DistanceBetweenTwoNodesInBinaryTree tree = new DistanceBetweenTwoNodesInBinaryTree();
		tree.root = new Node(1);
		tree.root.leftChild = new Node(2);
        tree.root.rightChild = new Node(3);
        tree.root.leftChild.leftChild = new Node(4);
        tree.root.leftChild.rightChild = new Node(5);
        tree.root.rightChild.leftChild = new Node(6);
        tree.root.rightChild.rightChild = new Node(7);
        tree.root.rightChild.leftChild.rightChild = new Node(8);
        
        System.out.println(tree.findDistance(tree.root, 4, 6));
	}

}
