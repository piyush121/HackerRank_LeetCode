package hackerRank;

import java.util.*;

public class isItPossible {
	
	static class Pair{
		int x;
		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		int y;
		
		Pair(int x,int y)
		{
			this.x=x;
			this.y=y;
		}
		
		
	}
	
	static Queue<Pair> list=new LinkedList<>();
	
	static String isitpossible(int a, int b, int c, int d) {
			Pair source=new Pair(a,b);
			Pair dest=new Pair(c,d);
			list.add(source);
			while(!list.isEmpty())
			{
				Pair pair=list.poll();
				if(pair.getX()==dest.getX() && pair.getY()==dest.getY())
					return "Yes";
				else
					{	int sum=pair.getX()+pair.getY();
						if(sum<=Math.max(c, d))
						{
							list.add(new Pair(sum,pair.getY()));
							list.add(new Pair(pair.getX(),sum));
						}
						

					}
				
			}
			
			return "No";
			

    }
	public static void main(String[] args) {
		String str=isitpossible(1, 4, 5, 9);
		System.out.println(str);
	}
}
