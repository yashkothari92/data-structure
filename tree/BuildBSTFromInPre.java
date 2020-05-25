package tree;

public class BuildBSTFromInPre {

	int preIdx = 0;

	public static void main(String[] args) {
		BuildBSTFromInPre obj = new BuildBSTFromInPre();

		int[] pre = { 1, 2 }; // {3,9,20,15,7};
		int[] in = { 2, 1 }; // {9,3,15,20,7};

		BSTNode root = obj.buildTree(pre, in);
		System.out.println(root);
	}

	public BSTNode buildTree(int[] preorder, int[] inorder) {
		int inStartIdx = 0;
		int inEndIdx = inorder.length - 1;
		return buildTreeSub(preorder, inorder, inStartIdx, inEndIdx);
	}

	public BSTNode buildTreeSub(int[] preorder, int[] inorder, int inStartIdx, int inEndIdx) {
		// when nothing to check (or empty), return null
		if (inStartIdx > inEndIdx) {
			return null;
		}

		BSTNode node = new BSTNode(preorder[preIdx++]);

		// when single element, return it
		if (inStartIdx == inEndIdx) {
			return node;
		}

		// search preorder element in inorder[] array
		int idx = search(node.data, inorder, inStartIdx, inEndIdx);
		// assign smaller index to left
		node.left = buildTreeSub(preorder, inorder, inStartIdx, idx - 1);
		// assign larger index to right
		node.right = buildTreeSub(preorder, inorder, idx + 1, inEndIdx);

		return node;
	}

	public int search(int nodeVal, int[] inorder, int inStartIdx, int inEndIdx) {
		for (int idx = inStartIdx; idx <= inEndIdx; idx++) {
			if (nodeVal == inorder[idx]) {
				return idx;
			}
		}
		return 0;
	}
}
