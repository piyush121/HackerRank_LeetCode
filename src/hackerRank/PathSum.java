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
	    public boolean hasPathSum(TreeNode root, int sum) {
	        if(root==null)
	        	return false;
	        else if(root.left==null && root.right==null)
	            {if(root.val==sum)
	                return true;
	             else
	                return false;
	            }
	    
	        return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val); // Sending the reduced value to the child.
	            
	        
	    }
	}

}
