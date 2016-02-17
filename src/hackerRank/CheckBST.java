package hackerRank;

public class CheckBST {
	static boolean left;
	static boolean right;
	
	public static boolean isBST(treeNode root)
	{
		if(root==null)
			return true;
		if(root.left!=null)
		{
			if(root.data>=root.left.data )
				left= isBST(root.left);
			else
				return false;
		}
		if(root.right!=null)
			{
			if(root.data<root.right.data )
				right= isBST(root.right);
			else
				return false;
			}
		return left && right;
	}

	 public static void main(String[] args) {
	 		treeNode node1=new treeNode(4,null,null);
	 		treeNode node2=new treeNode(5,null,null);
	 		treeNode node3=new treeNode(2,null,null);
	 		treeNode node4=new treeNode(1,null,null);
	 		treeNode node5=new treeNode(3,null,null);
	 		treeNode node6=new treeNode(0,null,null);
	 		
	 		binaryTree mytree=new binaryTree();
	 		mytree.add(node1);
	 		mytree.add(node2);
	 		mytree.add(node3);
	 		mytree.add(node4);
	 		mytree.add(node5);
	 		mytree.add(node6);
	 		//mytree.root.right=new treeNode(2,null,null);

	 		System.out.println(isBST(mytree.root));
	 		}

}
