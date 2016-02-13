package hackerRank;

import java.util.Stack;

public class PostOrderIterative {
	
	public static void postOrder(treeNode root)
	{
		Stack <treeNode> mystack=new Stack<>();
		mystack.push(root);
		while(root!=null)
		{
			mystack.push(root);
			root=root.left;
		}
		
		while(!mystack.isEmpty())
		{
			treeNode node=mystack.peek();
			
			if(node.right!=null)
			{
				mystack.push(node.right);
				node=node.right;

				while(node.left!=null)
					{
						mystack.push(node.left);
						node=node.left;
					}
			}
			else
				System.out.println(mystack.pop().data);

		}
		
	}
	
public static void main(String[] args) {
		
		treeNode node1=new treeNode(4,null,null);
		treeNode node2=new treeNode(5,null,null);
		treeNode node3=new treeNode(2,null,null);
		treeNode node4=new treeNode(1,null,null);
		treeNode node5=new treeNode(3,null,null);
		treeNode node6=new treeNode(6,null,null);

		binaryTree mytree=new binaryTree();
		mytree.add(node1);
		mytree.add(node2);
		mytree.add(node3);
		mytree.add(node4);
		mytree.add(node5);
		mytree.add(node6);
		System.out.println("Post Order Traversal...");
		postOrder(mytree.root);
	}

}
