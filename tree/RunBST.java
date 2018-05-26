package tree;

public class RunBST {

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		BSTNode<Integer> root = null;
		root = bst.insert(root, 14);
		root = bst.insert(root, 34);
		root = bst.insert(root, 4);
		root = bst.insert(root, 24);
		root = bst.insert(root, 32);
		root = bst.insert(root, 6);
		root = bst.insert(root, 1);
		root = bst.insert(root, 13);
		root = bst.insert(root, 41);
		root = bst.insert(root, 0);
		
		System.out.println("Search 14 ? "+bst.find(root, 14));
		System.out.println("Search 66 ? "+bst.find(root, 66));

	
		System.out.println("Min node "+bst.findMaxRecursively(root));
		System.out.println("Max node "+bst.findMinRecursively(root));
		
		System.out.println("Min node "+bst.findMinIteratively(root));
		System.out.println("Max node "+bst.findMaxIteratively(root));
		
		System.out.println("height of tree : "+bst.findHeight(root));
		System.out.println("Height_i "+bst.getHeight_i(root));


		System.out.println("Pre-order");
		bst.preOrder(root);
		System.out.println("\nIn-order");
		bst.inOrder(root);
		System.out.println("\nPost-order");
		bst.postOrder(root);
		
		System.out.println("\ndeleting 34...");
		root = bst.deleteNode(root, 34);
		bst.preOrder(root);
		System.out.println("\n");
		bst.inOrder(root);
		
		BSTNode<Integer> val = bst.getInOrderSuccessor(root, 14);
		if(val != null) {
			System.out.println("\nsuccessor -> "+val.data);
		}
		
		BSTNode<Integer> pred = bst.getInOrderPredecessor(root, 32);
		if(pred != null) {
			System.out.println("\npredecessor -> "+pred.data);
		}
	}
}
