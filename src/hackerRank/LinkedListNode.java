package hackerRank;

class LinkNode{
	int data;
	LinkNode next=null;
	LinkNode prev=null;
	@Override
	public String toString() {
		return "LinkNode [data=" + data + "]";
	}
	public LinkNode(int data) {
		this.data = data;
	}
	
	
}

public class LinkedListNode {
	
	public static LinkNode reverseGroup(LinkNode head,int k)
	{
		LinkNode curr=head;
		LinkNode prev=null;
		LinkNode next=curr.next;
		int count=0;
		while(count<k && curr!=null)
		{
			curr.next=prev;
			prev=curr;
			curr=next;
			if(next!=null)
				next=curr.next;
			count++;
		}
		if(curr!=null)
			head.next=reverseGroup(curr, k);

		return prev;
	}
	
	public static void main(String[] args) {
		LinkNode myHead=new LinkNode(1);
		myHead.next=new LinkNode(2);
		myHead.next.next=new LinkNode(3);
		myHead.next.next.next=new LinkNode(4);
		myHead.next.next.next.next=new LinkNode(5);
		LinkNode ptr=reverseGroup(myHead, 2);
		while(ptr!=null)
		{
			System.out.println(ptr.data);
			ptr=ptr.next;
		}

	}

}
