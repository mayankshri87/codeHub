package expressionTree;

/*Now For constructing expression tree we use a stack. We loop through input expression and do following for every character.
1) If character is operand push that into stack
2) If character is operator pop two values from stack make them its child and push current node again.
At the end only element of stack will be root of expression tree.*/

import java.util.Stack;

class Node{
	char data;
	Node left;
	Node right;
	
	Node(char data){
		this.data = data;
		this.left=this.right=null;
	}
}
public class ExpressionTree {

	Node root;
	
	
	public Node constructTree(char[] array){
		
		Stack<Node> stack = new Stack<Node>();
		Node t, t1, t2;
		
		for(char c: array){
			//check if the character is not a operator
			if(!isOperator(c)){
				//push on to the stack if the character is not operator
				stack.push(new Node(c));
			}else{
				//else character is operator, in this case pop tow nodes from stack and make left and right child of the node newly created with operaotr character.
				t = new Node(c);
				
				t1 = stack.pop();
				t2 = stack.pop();
				
				t.right = t1;
				t.left = t2;
				
				stack.push(t);
			}
		}
		//setting the root;
		t = stack.peek();
		
		stack.pop();
		return t;
	}
	
	public void printInorder(Node root){
		if(root==null){
			return;
		}
		
		printInorder(root.left);
		System.out.print(root.data + " ");
		printInorder(root.right);
	}
	
	private boolean isOperator(char c) {
		if(c=='+' || c=='-' || c=='*' || c=='/' || c=='%')
			return true;
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExpressionTree tree = new ExpressionTree();
		
		String str = "ab+ef*g*-";
		
		char[] array = str.toCharArray();
		
		tree.root = tree.constructTree(array);
		
		tree.printInorder(tree.root);
		
	}

}
