package hobby.binaryTrees;

/*
 * Find the number of turns from one node to another
 * 
 *
 * 				50
 * 		20				90
 * 10		30		5		35
 * 	 200
 */
public class TurnsInTrees {
	
	static boolean found = false;
	public static void main(String[] args) {
		BinaryTreeUtils utils = new BinaryTreeUtils();
		BinaryTree root = null;
		root = utils.insertData(root);
		int turns = findTurns(root, 200, 5);
		if(turns == -1) {
			System.out.println("Tree is empty");
		}
		else {
			System.out.println("Number of turns are:: " + turns);
		}
	}
	
	static int findTurns(BinaryTree root, int n1, int n2) {
		
		if(root == null) {
			return -1;
		}
		
		BinaryTree lca = null;
		lca = findLCA(root, n1, n2);
		
		System.out.println("LCA is :: " + lca.getData());
		
		int turn1 = findTurnsFromLCA(lca, n1, 1, 0);
		found = false;
		int turn2 = findTurnsFromLCA(lca, n2, 2, 0);
		System.out.println(turn1 + "  " + turn2);
		if(lca.getData() == n1 || lca.getData() == n2) {
			return turn1 + turn2;
		}
		return 1 + turn1 + turn2;
	}

	static int findTurnsFromLCA(BinaryTree lca, int num, int way, int sum) {
		if(lca == null) {
			return -1;
		}
		if(lca.getData() == num) {
			found = true;
			return 0;
		}
		if(way == 1) {
			if(found == false) {
				if(sum == -1)
					sum = 0;
				sum = findTurnsFromLCA(lca.getLeft(), num, 1, sum);
			}
			if(found == false) {
				if(sum == -1)
					sum = 0;
				sum = 1 + findTurnsFromLCA(lca.getRight(), num, 2, sum);
			}
		}
		else if(way == 2) {
			if(found == false) {
				if(sum == -1)
					sum = 0;
				sum = findTurnsFromLCA(lca.getRight(), num, 2, sum);
			}
			if(found == false) {
				if(sum == -1)
					sum = 0;
				sum = 1 + findTurnsFromLCA(lca.getLeft(), num, 1, sum);
			}
		}
		return sum;
	}
	
	static BinaryTree findLCA(BinaryTree root, int n1, int n2) {
		if(root == null) {
			return root;
		}
		if(root.getData() == n1 || root.getData() == n2) {
			return root;
		}
		BinaryTree leftLCA = findLCA(root.getLeft(), n1, n2);
		BinaryTree rightLCA = findLCA(root.getRight(), n1, n2);
		
		if(leftLCA != null && rightLCA != null) {
			return root;
		}
		return (leftLCA != null)?leftLCA : rightLCA;
	}
}
