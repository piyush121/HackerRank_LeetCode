package hackerRank;

public class BinaryTreetoDoublyLL {
	static treeNode last=null;
	static treeNode head=null;
	public static void binaryToLL(treeNode root){
		if(root==null)
			return;
		binaryToLL(root.left);
		if(last==null){
			head=root;
		}
		else{
			last.right=root;

		}
		root.left=last;
		last=root;
	
		binaryToLL(root.right);
	
	}

}
