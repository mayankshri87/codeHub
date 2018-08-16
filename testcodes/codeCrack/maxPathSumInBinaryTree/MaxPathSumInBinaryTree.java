package maxPathSumInBinaryTree;

class Node{
	int data;
	Node left;
	Node right;
	
	Node(int data){
		this.data = data;
		this.left=null;
		this.right=null;
	}
}
class Res{
	public int val;
}
public class MaxPathSumInBinaryTree {

	Node root;
	static int maxSum = Integer.MIN_VALUE;
	
	// This function returns overall maximum path sum in 'res'
    // And returns max path sum going through root.
	public int findMaxPath(Node root, Res res){
		
		//Base-condition :-
		if(root==null){
			return 0;
		}
		
		 // l and r store maximum path sum going through left and
        // right child of root respectively
		int maxLeft = findMaxPath(root.left,res);
		int maxRight = findMaxPath(root.right,res);
		
		// Max path for parent call of root. This path must
        // include at-most one child of root
		int maximumSingle = Math.max(Math.max(maxLeft, maxRight) + root.data,root.data);
		
		// Max Top represents the sum when the Node under
        // consideration is the root of the maxsum path and no
        // ancestors of root are there in max sum path
		int maximumTop = Math.max(maximumSingle,maxLeft+maxRight+root.data);
		
		res.val = Math.max(maximumTop, res.val);
		
		return maximumSingle;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxPathSumInBinaryTree tree = new MaxPathSumInBinaryTree();
		tree.root = new Node(10);
        tree.root.left = new Node(2);
        tree.root.right = new Node(10);
        tree.root.left.left = new Node(20);
        tree.root.left.right = new Node(1);
        tree.root.right.right = new Node(-25);
        tree.root.right.right.left = new Node(3);
        tree.root.right.right.right = new Node(4);
        
        Res res = new Res();
        res.val = Integer.MIN_VALUE;
        tree.findMaxPath(tree.root,res);
        System.out.println(res.val);
	}

}
