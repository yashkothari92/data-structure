package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

	public BSTNode<Integer> root;
	public BSTNode<Integer> left;
	public BSTNode<Integer> right;
	
	public BSTNode<Integer> insert(BSTNode<Integer> root, int data) {
		//if tree is empty
		if(root == null) {
			BSTNode<Integer> node = new BSTNode<Integer>(data);
			root = node;
		}//if current_node is smaller than root(node), make its left child
		else if(data <= root.data) {
			root.left = insert(root.left, data);
		}//if current_node is greater than root(node), make its right child
		else {
			root.right = insert(root.right, data);
		}
		return root;
	}
	
	/*returns true if number is found in a tree, else false (if no such element is there)*/
	public BSTNode<Integer> find(BSTNode<Integer> root, int number) {
		if(root == null) {
			return null;
		}
		else if(root.data == number) {
			return root;
		}else if(number <= root.data){
			return find(root.left, number);
		}else {
			return find(root.right, number);
		}
	}
	
	/*Finds min & max element in Tree - both recurively & iteratively*/
	public int findMinRecursively(BSTNode<Integer> root) {
		if(root == null) return -1;
		
		if(root.left == null) {
			return root.data;
		}
		
		return findMinRecursively(root.left);
	}
	
	public int findMaxRecursively(BSTNode<Integer> root) {
		if(root == null) return -1;
		
		if(root.right == null) {
			return root.data;
		}
		
		return findMaxRecursively(root.right);
	}

	public int findMaxIteratively(BSTNode<Integer> root) {
		if(root == null) return -1;
		while(root.right != null) {
			root = root.right;
		}
		return root.data;
	}

	public int findMinIteratively(BSTNode<Integer> root) {
		if(root == null) return -1;
		while(root.left != null) {
			root = root.left;
		}
		return root.data;
	}
	
	public int findHeight(BSTNode<Integer> root) {
		if(root == null) return -1;
		/*int left_h = findHeight(root.left);
		int right_h = findHeight(root.right);
		System.out.println(root.data+"*?"+left_h+" "+right_h);
		return Math.max(left_h, right_h)+1;*/
		
		return Math.max(findHeight(root.left), findHeight(root.right))+1;
	}
	
	//iterative approach
	public int getHeight_i(BSTNode<Integer> root){
		if(root == null){
			return -1;
		}

		// Create an empty queue for level order traversal
		Queue<BSTNode> queue = new LinkedList<BSTNode>();
		
		//enqueue root, and initialize height with -1.
		queue.add(root);
		int height = -1;
		
		while(true){
			//q_count indicates no of nodes in a queue at current level
			int q_count = queue.size();
			if(q_count == 0){
				return height;
			}
			
			height++;
			
			//Dequeue all nodes of current level & enqueue all nodes of next level
			while(q_count > 0){
				BSTNode<Integer> tempNode = queue.peek();
				queue.remove();
				if(tempNode.left != null)
					queue.add(tempNode.left);
				if(tempNode.right != null)
					queue.add(tempNode.right);
				q_count--;
			}
		}
	}

	public void preOrder(BSTNode<Integer> root){
		if(root == null)
			return;
		System.out.print(root.data+" ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public void inOrder(BSTNode<?> root){
		if(root == null)
			return;
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
	}
	
	public void postOrder(BSTNode<?> root){
		if(root == null)
			return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data+" ");
	}
	
	// deletes node from Binary Search Tree.
	public BSTNode<Integer> deleteNode(BSTNode<Integer> root, int data) {
		
		if(root == null)
			return null;
		else if (data < root.data){
			root.left = deleteNode(root.left, data);
		}else if (data > root.data){
			root.right = deleteNode(root.right, data);
		}else //match found
		{
			//case: Node with only one child or no child
			if(root.left == null ){
				return root.right;
			}else if(root.right == null) {
				return root.left;
			}
			
			//case: Node with two children: Get the in-order successor (smallest element in right subtree)

			BSTNode<Integer> temp = root; //stores 'node to be deleted' in temporary variable
			//copies min (in-order successor to the parent's left or right - based on who calls this function last)
			root = getMinValue(root.right);
			//assigns the node to be deleted's left pointer to new replacing node's left
			root.left = temp.left;
			//this will make its right pointer to its child
			root.right = deleteNode(root.right, root.data);
		}
		return root;
	}
	
	private BSTNode<Integer> getMinValue(BSTNode<Integer> root) {
		BSTNode<Integer> min = root;
		while(root.left != null) {
			min = root.left;
			root = root.left;
		}
		return min;
	}
	
	public BSTNode<Integer> getInOrderSuccessor(BSTNode<Integer> root, int value){
		BSTNode<Integer> current = find(root, value);
		if(current == null) return null;
		
		//case1: right sub-tree non-empty; return the smallest element from right sub-tree
		if(current.right != null){
			return getMinValue(current.right);
		}else {
			BSTNode<Integer> successor = null;
			BSTNode<Integer> ancestor = root;
			
			while(ancestor != current) {
				if(current.data < ancestor.data){
					successor = ancestor;
					ancestor = ancestor.left;
				}else{
					ancestor = ancestor.right;
				}
			}
			return successor;
		}
	}
	
	private BSTNode<Integer> getMaxValue(BSTNode<Integer> root) {
		BSTNode<Integer> max = null;
		if(root != null) {
			max = root.right;
			root = root.right;
		}
		return max;
	}
	
	public BSTNode<Integer> getInOrderPredecessor(BSTNode<Integer> root, int value) {
		BSTNode<Integer> current = find(root, value);
		
		if(current == null) return null;
		
		//case1: right sub-tree non-empty; return the smallest element from right sub-tree
		if(current.left != null){
			return getMaxValue(current.left);
		}else {
			BSTNode<Integer> predecessor = null;
			BSTNode<Integer> ancestor = root;
			
			while(ancestor != current){
				if(current.data > ancestor.data){
					predecessor = ancestor;
					ancestor = ancestor.right;
				}else{
					ancestor = ancestor.left;
				}
			}
			return predecessor;
		}
	}
}
