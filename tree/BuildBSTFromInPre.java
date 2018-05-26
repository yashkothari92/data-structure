package tree;

public class BuildBSTFromInPre {

	public static int preIdx = 0;
	
	public static void main(String[] args) {
		
		BuildBSTFromInPre bst_in_pre = new BuildBSTFromInPre();
		
		int[] pre = {11, 8, 4, 9, 21, 13, 30, 36};
		int[] in = {4, 8, 9,11, 13, 21, 30, 36};
		
		int in_length = in.length; 
		
		BSTNode root = bst_in_pre.buildBST(pre, in, 0, in_length-1);	
		System.out.println("-----\n");
		bst_in_pre.inOrderTraversal(root);
	}

	private BSTNode<Integer> buildBST(int[] pre, int[] in, int inStart, int inEnd) {
		//case 1: if inOrder is null
		if(inStart > inEnd){
			return null;
		}
		
		BSTNode<Integer> node = new BSTNode<Integer>(pre[preIdx++]);
				
		//case2: if inOrder has only one element
		if(inStart == inEnd){
			return node;
		}
		
		//search an element of (preOrder) in inOrder
		int idx = search(node.data, in, inStart, inEnd);
		
		node.left = buildBST(pre, in, inStart, idx-1);
		node.right = buildBST(pre, in, idx+1, inEnd);
		
		return node;
	}

	private int search(int data, int[] in, int inStart, int inEnd) {
		
		for (int i = inStart; i < inEnd; i++) {
			if (data == in[i]) {
				return i;
			}
		}
		return 0;
	}
	
	public void inOrderTraversal(BSTNode<Integer> root) {
		
		if(root == null) return;
		
		inOrderTraversal(root.left);
		System.out.print(root.data+" ");
		inOrderTraversal(root.right);
	}
}
