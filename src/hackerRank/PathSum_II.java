package hackerRank;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PathSum_II {
   static  List<List<Integer>> list=new ArrayList<>();
   static int count=0;

	
	 public static List<List<Integer>> pathSum(treeNode root, int sum) {
		 ArrayList<Integer> mylist=new ArrayList<>();

		 recurPathSum(root,sum,mylist);
	        return list;
	        
	    }
	        public static void recurPathSum(treeNode root, int sum, ArrayList<Integer> list1) {
	        	
	        	if(root==null)
	        		return ;
				list1.add(root.data);

	        	if(root.left==null && root.right==null)
	        		{
	        		
	        		if(sum==root.data)
	        			{
	        				list.add(list1);
	        				System.out.println(list1);
	        				 
	        			}
	        		}
	        	else
	        		{
		           		recurPathSum(root.left,sum-root.data,list1);
		        		recurPathSum(root.right,sum-root.data,list1);
	        		}
        		list1.remove(list1.size()-1);
	        	

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
	    		Stack<treeNode> stack=new Stack<>();
	    		pathSum(mytree.root, 9);
	    		System.out.println(list);
	    		}

}
