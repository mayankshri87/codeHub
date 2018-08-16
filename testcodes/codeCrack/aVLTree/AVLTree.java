package aVLTree;
/*
 * 
 * Deletion in BST
 * 1) Node to be deleted is leaf: Simply remove from the tree.

              50                            50
           /     \         delete(20)      /   \
          30      70       --------->    30     70 
         /  \    /  \                     \    /  \ 
       20   40  60   80                   40  60   80
2) Node to be deleted has only one child: Copy the child to the node and delete the child

              50                            50
           /     \         delete(30)      /   \
          30      70       --------->    40     70 
            \    /  \                          /  \ 
            40  60   80                       60   80
3) Node to be deleted has two children: Find inorder successor of the node. Copy contents of the inorder successor to the node and delete the inorder successor. 
Note that inorder predecessor can also be used.

              50                            60
           /     \         delete(50)      /   \
          40      70       --------->    40    70 
                 /  \                            \ 
                60   80                           80
 * */
class Node{
	int data;
	Node left;
	Node right;
	int height;
	
	Node(int data){
		this.data = data;
		this.left = null;
		this.right = null;
		this.height = 1;
	}
	
	
}
public class AVLTree {

	Node root;
	int getHeight(Node node){
	
		if(node==null)
			return 0;
		
		return node.height;
	}
	private int getBalance(Node node) {
		
		if(node == null){
			return 0;
		}
		return getHeight(node.left) - getHeight(node.right);
	}
	
	int max(int a, int b) {
		return (a > b) ? a : b;
	}
	
	private Node rightRotation(Node z) {
		Node y = z.left;
		Node t3 = y.right;
		//Perform rotation
		y.right = z;
		z.left = t3;
		
		//adjusting the heights after the rotation
		z.height = max(getHeight(z.left), getHeight(z.right))+1;
		y.height = max(getHeight(y.left), getHeight(y.right))+1;
		
		//return the new root
		return y;
	}
	
	
	private Node leftRotation(Node z) {
		Node y = z.right;
		Node t2 = y.left;
		
		//Perform rotation
		y.left = z;
		z.right = t2;
		
		//adjust heights
		
		y.height = max(getHeight(y.left), getHeight(y.right));
		z.height = max(getHeight(z.left), getHeight(z.right));
		
		return y;
		
	}
	public Node insertNode(Node node,int data){
	
		//Base case - when node is null then return the new node.
		if(node==null)
			return (new Node(data));
		
		//Standard BST insertion
		if(data<node.data){
			node.left = insertNode(node.left, data);
		}else if(data>node.data){
			node.right = insertNode(node.right, data);
		}else{
			//no duplicates are allowed
			return node;
		}
		
		node.height = 1 + max(getHeight(node.left), getHeight(node.right));
		
		int balance = getBalance(node);
		//Left Left Case
		if(balance>1 && data<node.left.data){
			return rightRotation(node);
		}
		// Right Right Case
		if(balance<-1 && data>node.right.data){
			return leftRotation(node);
		}
		// Left Right Case
		if(balance>1 && data>node.left.data){
			node.left = leftRotation(node.left);
			return rightRotation(node);
		}
		// Right Left Case
		if(balance < -1 && data<node.right.data){
			node.right = rightRotation(node.right);
			return leftRotation(node);
		}
		 /* return the (unchanged) node pointer */
		return node;
	}
	
	public Node delete(Node node, int data){
		if(node == null){
			return node;
		}//if the node to be deleted has data less than the node data then we traverse to left else right
		if(data<node.data){
			node.left = delete(node.left, data);
		}else if(data>node.data){
			node.right = delete(node.right, data);
		}else{
			//consider the case if there is only child
			if(node.left==null || node.right==null){
				Node temp = null;
				if(node.left==null){
					temp = node.right;
				}
				if(node.right==null){
					temp = node.left;
				}
				//consider a case when there is no children
				if(temp==null){
					node = temp;
				}else{
					node = temp; //copy the content of the children to node;
				}
				
			}else{
				//else case if there are two children of the node in this case we will get the inorder successor
				/*inorder successor is needed only when right child is not empty. In this particular case, 
				 * inorder successor can be obtained by finding the minimum value in right child of the node.*/
				 Node temp = getMin(node.right);
				 
				 node.data = temp.data;
				 
				 node.right = delete(node.right, temp.data);
			}
		}
		
		if(node==null){
			return node;
		}
		//update the height of the node
		node.height = Math.max(getHeight(node.left), getHeight(node.right))+1;
		
		//get balance of the node
		
		int balance = getBalance(node);
		
		if(balance>1 && data<node.left.data){
			return rightRotation(node);
		}
		if(balance<-1 && data>node.right.data){
			return leftRotation(node);
		}
		// Left Right Case
		if(balance>1 && data>node.left.data){
			node.left = leftRotation(node.left);
			return rightRotation(node);
		}
		// Right Left Case
		if(balance < -1 && data<node.right.data){
			node.right = rightRotation(node.right);
			return leftRotation(node);
		}
		
		return node;
	}
	
	 private Node getMin(Node node) {
		Node temp = node;

		while(temp.left!=null){
			temp=temp.left;
		}
		
		return temp;
	}
	void preOrder(Node node) {
	        if (node != null) {
	            System.out.print(node.data + " ");
	            preOrder(node.left);
	            preOrder(node.right);
	        }
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AVLTree tree = new AVLTree();
		 
        /* Constructing tree given in the above figure */
        tree.root = tree.insertNode(tree.root, 10);
        tree.root = tree.insertNode(tree.root, 20);
        tree.root = tree.insertNode(tree.root, 30);
        tree.root = tree.insertNode(tree.root, 40);
        tree.root = tree.insertNode(tree.root, 50);
        tree.root = tree.insertNode(tree.root, 25);
        
        /* The constructed AVL Tree would be
        30
       /  \
     20   40
    /  \     \
   10  25    50
   */
   System.out.println("Preorder traversal" +
                   " of constructed tree is : ");
   tree.preOrder(tree.root);
        
	}

}
