package hackerRank;

import java.util.Stack;

public class RootToLeaf {
	
	
	public static void printPath(treeeNode root,Stack<treeeNode> st)
	{	
		if(root==null)
			return;
		st.push(root);
		if(root.left == null && root.right==null)
		{
			for(treeeNode st1 : st)
				System.out.print(st1.data);
			System.out.println();
			
		}
		else
			{
				printPath(root.left,st);
				printPath(root.right,st);
				
		    }
		st.pop();
		
		
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
		Stack<treeeNode> stack=new Stack<>();
		printPath(mytree.root, stack);
		}

}
