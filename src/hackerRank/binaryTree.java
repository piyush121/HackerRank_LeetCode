package hackerRank;


class treeeNode
{
	int data;
	treeeNode left,right;
	treeeNode parent=null;
	
	treeeNode(int data,treeeNode left,treeeNode right)
	{
		this.data=data;
		this.left=left;
		this.right=right;
	}
	
	@Override
	public String toString() {
		return "treeeNode [data=" + data + ", left=" + left + ", right=" + right + ", parent=" + parent + "]";
	}
}

public class binaryTree {
	treeeNode root;
	
	public void add(treeeNode node)
	{
		if(root==null)
			root=node;
		else
		{	
			treeeNode ptr=root;
			while(ptr!=null)
			{
				if(node.data>ptr.data)
				{
					if(ptr.right!=null)
						ptr=ptr.right;
					else
						break;
				}
				else
					{
					if(ptr.left!=null)
						ptr=ptr.left;
					else
						break;
					}
			}
		if(ptr.data>=node.data)
			ptr.left=node;
		else
			ptr.right=node;
		
		}
			
	}
	public static void inOrder(treeeNode root)
	{
		treeeNode ptr=root;
		if (root ==null)
			return;
		inOrder(ptr.left);
		System.out.print(ptr.data);
		inOrder(ptr.right);
	}
	public static void preOrder(treeeNode root)
	{
		treeeNode ptr=root;
		if (root ==null)
			return;
		System.out.print(ptr.data);
		preOrder(ptr.left);
		preOrder(ptr.right);
	}
	public static void postOrder(treeeNode root)
	{
		treeeNode ptr=root;
		if (root ==null)
			return;
		postOrder(ptr.left);
		postOrder(ptr.right);
		System.out.print(ptr.data);

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
		System.out.println("In Order Traversal");
		inOrder(mytree.root);
		System.out.println("\nPost Order Traversal");
		postOrder(mytree.root);
		System.out.println("\nPre Order Traversal");
		preOrder(mytree.root);
		}
}
