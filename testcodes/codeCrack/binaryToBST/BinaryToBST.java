package binaryToBST;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/*This is the code to convert binary tree to BST
 * eg: Input:
          10
         /  \
        2    7
       / \
      8   4
Output:
          8
         /  \
        4    10
       / \
      2   7
      
      Algorithm is :
      
    1) Create a temp array arr[] that stores in-order traversal of the tree. This step takes O(n) time.
	2) Sort the temp array arr[]. Time complexity of this step depends upon the sorting algorithm. In the following implementation, Quick Sort is used which takes (n^2) time. This can be done in O(nLogn) time using Heap Sort or Merge Sort.
	3) Again do in-order traversal of tree and copy array elements to tree nodes one by one. This step takes O(n) time.
      */

class Node{
	int data;
	Node leftChild;
	Node rightChild;
	
	public Node(int data){
		this.data = data;
		this.leftChild = null;
		this.rightChild = null;
	}
}

public class BinaryToBST {

	Node root;
	List arr = new ArrayList<Integer>();
	int index = 0;
	
	/*Inorder traversal of tree and adding node to the array*/
	public void inOrderTraversal(Node node)
	{
		if(node!=null){
			
			inOrderTraversal(node.leftChild);
			arr.add(node.data);
			inOrderTraversal(node.rightChild);
		}
	}
	
	/*method to conver the binary tree to binary search tree*/
	public void convertBinaryTreeToBinarySearchTree()
	{
		if(root==null)
		{
			return;
		}
		/*Inorder traversal to fill array*/
		inOrderTraversal(root);
		/*sorting the array*/
		Collections.sort(arr);
		/*Traverse tree using inorder traversal, and replace the node data with data in sorted array*/
		replaceNodeInInorderTraverse(root);
		
	}
	/*replace method to replace the node data by traversing tree in inorder*/
	public void replaceNodeInInorderTraverse(Node node)
	{
		if(node!=null)
		{
			
			replaceNodeInInorderTraverse(node.leftChild);
			node.data = (int) arr.get(index);
			index++;
			replaceNodeInInorderTraverse(node.rightChild);
		}
	}
	
	public void printTreeInorder(Node node)
	{
		if(node!=null)
		{
			
			printTreeInorder(node.leftChild);
			System.out.print(" "+node.data);
			printTreeInorder(node.rightChild);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryToBST tree = new BinaryToBST();
		tree.root = new Node(10);
		tree.root.leftChild = new Node(2);
		tree.root.leftChild.leftChild = new Node(8);
		tree.root.leftChild.rightChild = new Node(4);
		tree.root.rightChild = new Node(7);
		
		tree.convertBinaryTreeToBinarySearchTree();
		tree.printTreeInorder(tree.root);
	}

}
