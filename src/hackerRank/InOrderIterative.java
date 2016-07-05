package hackerRank;

import java.util.Stack;

public class InOrderIterative {
	
	public static void InTraversal(treeeNode root)
	{
		
		Stack <treeeNode> mystack=new Stack<>();
		mystack.push(root);
		while(mystack.peek().left!=null) //going left
			mystack.push(mystack.peek().left);
		while(!mystack.isEmpty())
		{	
			
			treeeNode node=mystack.pop();
			System.out.println(node.data);
			
			if(node.right!=null)		//going right
				{
					mystack.push(node.right);
					while(mystack.peek().left!=null) //going left
						mystack.push(mystack.peek().left);
				
				}

				}

			
			
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
	System.out.println("In Order Traversal...");
	InTraversal(mytree.root);
}		
		
		
	}


