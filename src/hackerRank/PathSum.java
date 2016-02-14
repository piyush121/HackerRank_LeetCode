package hackerRank;

public class PathSum {
	
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int data;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { data = x; }
	 * }
	 */
	    
	public class Solution {
	    int count=0;
	    public boolean hasPathSum(treeNode root, int sum) {
	        if(root==null)
	            {if(count==sum)
	                return true;
	             else
	                return false;
	            }
	        else
	        count+=root.data;
	        return hasPathSum(root.left,sum) || hasPathSum(root.right,sum);
	            
	        
	    }
	}

}
