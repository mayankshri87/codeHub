package serializeAndDeserializeBTree;

import java.awt.List;
import java.util.ArrayList;

import com.graphbuilder.struc.Stack;

class Node{
	int data;
	Node left;
	Node right;
	
	Node(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
public class SerializeAndDeserializeBTree {

	
	/* To serialize the binary, we will follow the approach of preOrder traversal, Here in this case we are not using recursion for traversal,
	 * else we are using stack*/
	public String serializeBTree(Node root){
		
		//If the root is null then return null
		if(root == null){
			return null;
		}
		StringBuilder string = new StringBuilder();
		Stack stack = new Stack();
		//pushing the root node to the stack
		stack.push(root);
		
		//looping through the stack and appending the node data in to the string builder
		while(!stack.isEmpty()){
			Node temp = (Node)stack.pop();
			
			if(temp!=null){
				string.append(temp.data+",");
				stack.push(temp.left);
				stack.push(temp.right);
			}else{
				string.append("#");
			}
		}
		
		
		return string.toString().substring(0,string.length()-1);
	}
	
	public Node deserializeBTree(String string)
	{
		/*String[] arr = string.split(",");
		int[] t = {0};
		System.out.println();
		List lis = new ArrayList<String>();
		lis.contains(p)*/
		return null;
		
	
		
	}
	
	
	public Node deserializeUtil(String[] arr){
		
		return null;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
