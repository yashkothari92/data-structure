package tree;

public class CheckIfBinaryTree {
	
	public boolean ifBinarySearchTree(BSTNode root) {
		/**
		 * For the root node, 
		 * i) its left subtree are lesser 
		 * ii) and right subtree is greater 
		 * iii) & left and right subtree themselves are binary search tree
		 */
		
		if(isSubtreeLesser(root.left, root.data) 
			&& isSubtreeGreater(root.right, root.data) 
			&& ifBinarySearchTree(root.left)
			&& ifBinarySearchTree(root.right)) {
			
		}
	}
	/**
	 * isSubtreeLesser takes two arguments:
	 * <p> root of the tree/sub-tree 
	 * <p>and value against which we'll compare if its lesser
	 **/
	private boolean isSubtreeLesser(BSTNode root, int data) {
		if(root == null)
			return true;
		
		if(root.data <= data &&
			isSubtreeGreater(root.left, data) &&
			isSubtreeGreater(root.right, data){
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * isSubtreeGreater takes two arguments:
	 * <p> root of the tree/sub-tree 
	 * <p>and value against which we'll compare if its greater
	 **/
	private boolean isSubtreeGreater(BSTNode right, int data) {
		// TODO Auto-generated method stub
		return false;
	}

}
