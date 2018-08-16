package printTreeVertically;

import com.sun.xml.internal.ws.message.MimeAttachmentSet;

/*        1
        /    \
       2      3
      / \    / \
     4   5  6   7
             \   \
              8   9 
               
			  
The output of print this tree vertically will be:
4
2
1 5 6
3 8
7
9*/
class Node {
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

public class PrintTreeVertically {
	
	Node root;
	static int minimumDistance = 0;
	static int maximumDistance = 0;
	
		
		/*creating a internal class Node for the binary tree*/
		/*Note - This method will not be used in this program*/
		/*Add function will create a binary tree i.e. if the data is smaller then will go to the left child else will got the right child*/
		public void add(int data)
		{Node newNode = new Node(data);
			
			//If the tree has not created yet that means if the root node is null then first node will be the root node
			if(root==null)
			{
				root = newNode;
				return;
			}
			/*Insert node in a way that it will create a binary tree*/
			//focusNode will be the node we are focusing, it can be considered as pointer that will help to iterate over the tree.
			Node focusNode = root;
			Node parent;
			/*looping though the tree to insert the newlt created node at the right position*/
			while(true){
				parent = focusNode;
				/*will go the leftChild if the data is smaller or will go the rightChild if the data greater*/
				if(data<focusNode.data)
				{
					focusNode = focusNode.leftChild;
					if(focusNode == null)
					{
						parent.leftChild = newNode;
						return;
					}
				}else{
					
					focusNode = focusNode.rightChild;
					if(focusNode==null){
						parent.rightChild = newNode;
						return;
					}
				}
			}
			
			
		}
		
		
		public void pritVirtically()
		{
			if(root == null)
			{
				return;
			}else{
				/*find the minimum and maximum horizontal distance starting with root and horizontal distance of root from root is 0*/
				findMinMaxHorizontalDistance(root,0);
				
				for(int verticalLine = minimumDistance;verticalLine<=maximumDistance;verticalLine++)
				{
					printVerticalNode(root,verticalLine,0);
					System.out.println("");
				}
			}
		}

	private void printVerticalNode(Node node, int verticalLine, int horizontalDistance) {
			
		if(node == null)
			return;
		
		if(verticalLine == horizontalDistance)
			System.out.print(""+node.data );
		//traversing to leftChild and right child to match the limit
		printVerticalNode(node.leftChild, verticalLine, horizontalDistance-1);
		printVerticalNode(node.rightChild, verticalLine, horizontalDistance+1);
			
		}


	private void findMinMaxHorizontalDistance(Node node, int horizontalDistance) {

			if(node==null)
			{
				return;
			}
			
			if(minimumDistance>horizontalDistance)
			{
				minimumDistance = horizontalDistance;
			}else if(maximumDistance<horizontalDistance){
				maximumDistance = horizontalDistance;
			}
			//calling method recursively to find the minimum distance which is distance from root node to leftmost node.
			findMinMaxHorizontalDistance(node.leftChild,horizontalDistance-1);
			findMinMaxHorizontalDistance(node.rightChild, horizontalDistance+1);
			
		}

	public static void main(String[] args) {
		
		PrintTreeVertically tree = new PrintTreeVertically();
		
		tree.root = new Node(1);
        tree.root.leftChild = new Node(2);
        tree.root.rightChild = new Node(3);
        tree.root.leftChild.leftChild = new Node(4);
        tree.root.leftChild.rightChild = new Node(5);
        tree.root.rightChild.leftChild = new Node(6);
        tree.root.rightChild.rightChild = new Node(7);
        tree.root.rightChild.leftChild.rightChild = new Node(8);
        tree.root.rightChild.rightChild.rightChild = new Node(9);
        tree.pritVirtically();

	}

}
