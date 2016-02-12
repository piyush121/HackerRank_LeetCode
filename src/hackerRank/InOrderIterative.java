package hackerRank;

import java.util.Stack;

public class InOrderIterative {
	
	public static void InTraversal(treeNode root)
	{
		
		Stack <treeNode> mystack=new Stack<>();
		while(root!=null)
		{	
			while(root.left!=null)
				{
					mystack.push(root);
					root=root.left;
				}
			while(root.right!=null)
				{
					mystack.push(root);
					root=root.right;

				}

			System.out.println(mystack.pop());
			
			
		}
		
		System.out.println(root);
		
		
		
	}

}
