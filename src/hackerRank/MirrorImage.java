package hackerRank;

public class MirrorImage {
	
	public static void mirrorImage(treeeNode root)
	{
		if(root==null)
			return;
		else
		{
			System.out.println(root.data);

			mirrorImage(root.right);
			mirrorImage(root.left);
			
		}
	}

	 public static void main(String[] args) {
	 		treeeNode node1=new treeeNode(4,null,null);
	 		treeeNode node2=new treeeNode(5,null,null);
	 		treeeNode node3=new treeeNode(2,null,null);
	 		treeeNode node4=new treeeNode(1,null,null);
	 		treeeNode node5=new treeeNode(3,null,null);
	 		treeeNode node6=new treeeNode(0,null,null);
	 		
	 		binaryTree mytree=new binaryTree();
	 		mytree.add(node1);
	 		mytree.add(node2);
	 		mytree.add(node3);
	 		mytree.add(node4);
	 		mytree.add(node5);
	 		mytree.add(node6);

	 		mirrorImage(mytree.root);
	 		}
}
