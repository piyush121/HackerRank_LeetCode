package hackerRank;

import java.util.Stack;

public class RootToLeaf {
	
	
	public static void printPath(treeNode root,Stack<treeNode> st)
	{	
		if(root==null)
			return;
		st.push(root);
		if(root.left == null && root.right==null)
		{
			for(treeNode st1 : st)
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
		Stack<treeNode> stack=new Stack<>();
		printPath(mytree.root, stack);
		}

}
