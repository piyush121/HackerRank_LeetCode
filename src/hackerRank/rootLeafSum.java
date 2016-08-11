package hackerRank;


public class rootLeafSum {
	
	static boolean sum(treeeNode root,int sum,int total)
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
		treeeNode node1=new treeeNode(4,null,null);
		treeeNode node2=new treeeNode(5,null,null);
		treeeNode node3=new treeeNode(2,null,null);
		treeeNode node4=new treeeNode(1,null,null);
		treeeNode node5=new treeeNode(3,null,null);
		treeeNode node6=new treeeNode(3,null,null);

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
