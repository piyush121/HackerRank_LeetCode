package hackerRank;

import java.util.Stack;

public class ZigZagTraversal {
	static Stack<treeNode> st1=new Stack<>();
	static Stack<treeNode> st2=new Stack<>();
	public static void zigZag(treeNode root)
	{
		if(root==null)
			return;
		
		st1.push(root);
		while(!st1.isEmpty())
		{
			treeNode node=st1.pop();
			if(node.left!=null)
				st2.push(node.left);
			if(node.right!=null)
				st2.push(node.right);
	 		System.out.print(" "+node.data);

		}
 		System.out.println();

		while(!st2.isEmpty())
		{
			treeNode node=st2.pop();
			if(node.right!=null)
				st1.push(node.right);
			if(node.left!=null)
				st1.push(node.left);
	 		System.out.print(" "+node.data);

		}
 		System.out.println();
 		if(!st1.isEmpty())
 			zigZag(st1.pop());
 		
	}
	
	public static void zigZagEfficient(treeNode root) //O(n)
	{	
		 Stack<treeNode> st1=new Stack<>();
		 Stack<treeNode> st2=new Stack<>();
		boolean leftToRight=true;
		st1.push(root);
		while(!st1.isEmpty())
		{	
			treeNode node=st1.pop();
 			System.out.print(node.data+" ");

			if(leftToRight)
			{
				if(node.left!=null)
					st2.push(node.left);
				if(node.right!=null)
					st2.push(node.right);
			}
			else
			{
				if(node.right!=null)
					st2.push(node.right);
				if(node.left!=null)
					st2.push(node.left);
			}
			if(st1.isEmpty())
			{
				Stack<treeNode> temp=st1;
				st1=st2;
				st2=temp;
		 		System.out.println("");
		 		leftToRight=!leftToRight;

			}
			
			
		}
		
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
 		zigZag(mytree.root);

 		zigZagEfficient(mytree.root);
 		}
}
