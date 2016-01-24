package hackerRank;


public class rootLeafSum {
	
	static boolean sum(treeNode root,int sum,int total)
	{	
		if(root==null)
			return false;
		
		total+=root.data;
		if(total==sum && root.left==null && root.right==null)
			return true;
		
		else 
			return sum(root.left,sum,total)||sum(root.right,sum,total);
	}

	public static void main(String[] args) {
		treeNode node1=new treeNode(4,null,null);
		treeNode node2=new treeNode(5,null,null);
		treeNode node3=new treeNode(2,null,null);
		treeNode node4=new treeNode(1,null,null);
		treeNode node5=new treeNode(3,null,null);
		treeNode node6=new treeNode(3,null,null);

		binaryTree mytree=new binaryTree();
		mytree.add(node1);
		mytree.add(node2);
		mytree.add(node3);
		mytree.add(node4);
		mytree.add(node5);
		mytree.add(node6);
		System.out.println(sum(mytree.root,12,0));
	}
}
