package rightLeafNodeSum;

class Node{
	int data;
	Node left;
	Node right;
	
	Node(int data){
		this.data = data;
		left=null;
		right=null;
	}
}
public class RighLeafNodeSum {

	Node root;
	static int sum = 0;
	
	public void findRightLeafSum(Node node){
		if(node==null){
			return;
		}
		
		if(node.right!=null){
			if(node.right.right==null && node.right.left==null){
				sum = sum + node.right.data;
			}
		}
		
		findRightLeafSum(node.left);
		findRightLeafSum(node.right);
	}
	
	public static void main(String[] args) {

		RighLeafNodeSum tree = new RighLeafNodeSum();
		
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.left.left.right = new Node(2);
		tree.root.right.right = new Node(8);
		tree.root.right.right.left = new Node(6);
		tree.root.right.right.right = new Node(7);
		
		tree.findRightLeafSum(tree.root);
		
		System.out.println(sum);

	}

}
