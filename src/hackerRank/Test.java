/**
 * @author Piyush Chaudhary
 */
package hackerRank;
import java.util.*;
/**
 * Testing Java features.
 *
 */
public class Test {
	static List<List<Integer>> l =new ArrayList<>();
	public static void arraypermute(int arr[], int visited[], List<Integer> a, Set<List<Integer>> set)
	{
		if(a.size()==arr.length)
		{	if(!set.contains(a)) {
			l.add(a);
			set.add(a);
		}
			return;
		}
		for(int i=0;i<arr.length;i++)
		{
			if(visited[i]==0)
			{
				visited[i]=1;
				a.add(arr[i]);
				arraypermute(arr, visited, new ArrayList<>(a), set);
				a.remove(a.size()-1);
				visited[i]=0;
			}
		}
	}
	int[] minimum;
	public int mini(int arr[], int l, int r)
	{
		minimum=new int[arr.length];
		minimum[0]=arr[0];
		for(int i=1;i<arr.length;i++)
		{
			if(minimum[i-1]>arr[i])
				minimum[i]=arr[i];
			else
				minimum[i]=minimum[i-1];
		}
		return minimum[r];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]=new int[]{1,2,2};
		int visited[]=new int[arr.length];
		arraypermute(arr, visited, new ArrayList<>(), new HashSet<List<Integer>>());
		System.out.println(l);
	}

}
