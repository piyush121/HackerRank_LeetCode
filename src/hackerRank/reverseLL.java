package hackerRank;

class LLNode
{
	int data;
	LLNode next;
	
	LLNode(int x)
	{
		this.data=x;
		this.next=null;
	}
}

public class reverseLL {  //recursive way

	public static void reverse(LLNode curr,LLNode  prev)
	{
		if(curr.next==null)
		{
			curr.next=prev;
		}
		else
		{
			LLNode ptr=curr.next;
			curr.next=prev;
			reverse(ptr,curr);
		}
	}
}
