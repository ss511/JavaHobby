package hobby.binaryTrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeImplementation {

	public static void main(String[] args) {
		BinaryTreeUtils binaryTreeUtils = new BinaryTreeUtils();
		BinaryTree root = null;
		int choice;
		do{
			System.out.println("Enter Choice:"
					+ "\n1-Insert Data"
					+ "\n2-PreOrder Traversal"
					+ "\n3-InOrder Traversal"
					+ "\n4-PostOrder Traversal"
					+ "\n5-Level Order Traversal"
					+ "\n6-Max Depth"
					+ "\n7-Print Ancestors:"
					+ "\n8-Exit");
			Scanner in = new Scanner(System.in);
			choice = in.nextInt();
			switch(choice){
			case 1: 
				root = binaryTreeUtils.insertData(root);
				break;
			case 2:
				System.out.println("PreOrder Traversal::");
				binaryTreeUtils.preOrder(root);
				break;
			case 3:
				System.out.println("InOrder Traversal::");
				binaryTreeUtils.inOrder(root);
				break;
			case 4:
				System.out.println("PostOrder Traversal::");
				binaryTreeUtils.postOrder(root);
				break;
			case 5:
				System.out.println("Level Order Traversal::");
				binaryTreeUtils.levelOrder(root);
				break;
			case 6:
				int maxDepth = binaryTreeUtils.findMaxDepth(root);
				System.out.println("Max Depth is::: "+maxDepth);

				break;
			case 7:
				binaryTreeUtils.printAncestors(root, 200);
				break;
			case 8:
				break;
			default:
				System.out.println("Please Enter Correct Choice:::");
				break;

			}
		}while(choice != 8);


	}

}

class BinaryTreeUtils{
	public BinaryTree insertData(BinaryTree root){
		if(root == null){
			root = new BinaryTree();
			root.setData(50);
			root.setLeft(null);
			root.setRight(null);

			BinaryTree node = new BinaryTree();
			node.setData(20);
			node.setLeft(null);
			node.setRight(null);

			root.setLeft(node);

			node = new BinaryTree();
			node.setData(90);
			node.setLeft(null);
			node.setRight(null);

			root.setRight(node);

			node = new BinaryTree();
			node.setData(10);
			node.setLeft(null);
			node.setRight(null);

			root.getLeft().setLeft(node);

			node = new BinaryTree();
			node.setData(30);
			node.setLeft(null);
			node.setRight(null);

			root.getLeft().setRight(node);

			node = new BinaryTree();
			node.setData(5);
			node.setLeft(null);
			node.setRight(null);

			root.getRight().setLeft(node);

			node = new BinaryTree();
			node.setData(35);
			node.setLeft(null);
			node.setRight(null);
			
			root.getRight().setRight(node);
			
			node = new BinaryTree();
			node.setData(200);
			node.setLeft(null);
			node.setRight(null);

			root.getLeft().getLeft().setRight(node);
		}
		return root;
	}

	public void preOrder(BinaryTree root){
		if(root == null){
			return;
		}
		System.out.print(root.getData()+ " ");
		preOrder(root.getLeft());
		preOrder(root.getRight());
	}

	public void inOrder(BinaryTree root){
		if(root == null){
			return;
		}
		inOrder(root.getLeft());
		System.out.print(root.getData()+ " ");
		inOrder(root.getRight());
	}

	public void postOrder(BinaryTree root){
		if(root == null){
			return;
		}
		postOrder(root.getLeft());
		postOrder(root.getRight());
		System.out.print(root.getData()+ " ");
	}

	public void levelOrder(BinaryTree root){
		//Breadth First Traversal
		if(root!=null){
			Queue<BinaryTree> queue = new LinkedList<BinaryTree>();
			queue.add(root);
			while(!queue.isEmpty()){
				BinaryTree temp = queue.poll();
				System.out.print(temp.getData()+ " ");

				if(temp.getLeft() != null){
					queue.add(temp.getLeft());
				}
				if(temp.getRight() != null){
					queue.add(temp.getRight());
				}
			}
		}
		else
			System.out.println("Tree is Empty");

	}
	
	public int findMaxDepth(BinaryTree root){
		if(root == null){
			return 0;
		}
		else{
			int leftDepth = 1+findMaxDepth(root.getLeft());
			int rightDepth = 1+findMaxDepth(root.getRight());
			
			if(leftDepth > rightDepth){
				return leftDepth;
			}
			else{
				return rightDepth;
			}
		}
	}
	
	public boolean printAncestors(BinaryTree root, int target){
		if(root == null){
			return false;
		}
		if(root.getData() == target){
			return true;
		}
		
		if(printAncestors(root.getLeft(), target) || printAncestors(root.getRight(), target)){
			System.out.println(root.getData());
			return true;
		}
		return false;
	}
}


class BinaryTree{
	private int data;
	private BinaryTree left;
	private BinaryTree right;
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public BinaryTree getLeft() {
		return left;
	}
	public void setLeft(BinaryTree left) {
		this.left = left;
	}
	public BinaryTree getRight() {
		return right;
	}
	public void setRight(BinaryTree right) {
		this.right = right;
	}

}
