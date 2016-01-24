package hackerRank;


class treeNode
{
	int data;
	treeNode left,right;
	treeNode parent=null;
	
	treeNode(int data,treeNode left,treeNode right)
	{
		this.data=data;
		this.left=left;
		this.right=right;
	}
	
	@Override
	public String toString() {
		return "treeNode [data=" + data + ", left=" + left + ", right=" + right + ", parent=" + parent + "]";
	}
}

public class binaryTree {
	treeNode root;
	
	public void add(treeNode node)
	{
		if(root==null)
			root=node;
		else
		{	
			treeNode ptr=root;
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
	public static void inOrder(treeNode root)
	{
		treeNode ptr=root;
		if (root ==null)
			return;
		inOrder(ptr.left);
		System.out.print(ptr.data);
		inOrder(ptr.right);
	}
	public static void preOrder(treeNode root)
	{
		treeNode ptr=root;
		if (root ==null)
			return;
		System.out.print(ptr.data);
		preOrder(ptr.left);
		preOrder(ptr.right);
	}
	public static void postOrder(treeNode root)
	{
		treeNode ptr=root;
		if (root ==null)
			return;
		postOrder(ptr.left);
		postOrder(ptr.right);
		System.out.print(ptr.data);

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
		System.out.println("In Order Traversal");
		inOrder(mytree.root);
		System.out.println("\nPost Order Traversal");
		postOrder(mytree.root);
		System.out.println("\nPre Order Traversal");
		preOrder(mytree.root);
		}
}
