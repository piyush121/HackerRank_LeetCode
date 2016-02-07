package hackerRank;
import java.util.LinkedList;
import java.util.Queue;

class BTNode
{
	int data;
	BTNode left;
	BTNode right;
	
	BTNode(int x)
	{
		this.data=x;
		this.left=null;
		this.right=null;
	}
}

public class LevelOrderTraversalTree {
	
	public void levelOrder(BTNode root)
	{
		if(root==null)
			System.out.println("Null");
		else
			{
				Queue<BTNode> que=new LinkedList<>();
				que.add(root);
				while(!que.isEmpty())
				{	
					BTNode ptr=que.poll();
					if(ptr.left!=null)
						que.add(ptr.left);
					if(ptr.right!=null)
						que.add(ptr.right);
					System.out.println(ptr.data);
					
				}
			}
	}
	

}
