package hackerRank;

import java.util.ArrayList;

public class CheckBST {
	static boolean left;
	static boolean right;
	static treeNode prev=null;
	static ArrayList<Integer> arr=new ArrayList<>();
	
	public static boolean isBST(treeNode root,int min,int max)
	{
		if(root==null)
			return true;
		if(root.data<min || root.data>max )
				return false;
		
		return isBST(root.left,min,root.data)&&isBST(root.right,root.data,max);
	}
	
	public static void  isBST1(treeNode root)
	{
			if(root==null)
				return;
			else
			{
			
			isBST1(root.left);
			arr.add(root.data);
			isBST1(root.right);
			}
		
		
	}
	public static boolean BSTUtil(treeNode root)
	{
		isBST1(root);
		for(int i=0;i<arr.size()-1;i++)
		{
			if(arr.get(i)>arr.get(i+1))
				return false;
			
		}
		return true;
	}
	
	public static boolean isBSTEff(treeNode root)  //Hard to understand !!!!!!!
	{
		if(root==null)
			return true;
		if(!isBSTEff(root.left))
			return false;
		
		if(prev!=null && root.data<prev.data)
			return false;
		prev=root;
		return isBSTEff(root.right);
		
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
	 		//mytree.root.right=new treeNode(2,null,null);

	 		System.out.println(isBST(mytree.root,Integer.MIN_VALUE,Integer.MAX_VALUE));
	 		System.out.println(BSTUtil(mytree.root));
	 		System.out.println(isBSTEff(mytree.root));
	 		}

}
