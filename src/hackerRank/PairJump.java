package hackerRank;

import java.util.HashMap;
import java.util.LinkedList;

import javafx.util.Pair;

public class PairJump {
	static LinkedList<HashMap<Integer,Integer>> pairs = new LinkedList<HashMap<Integer, Integer>>();

	public static String pairCheck(int a,int b, int c , int d)
	{	 
		Integer key=0;
		 Integer value=0 ;
		 HashMap<Integer,Integer> myhash1=new HashMap<Integer, Integer>();
     	myhash1.put(a,b);
		pairs.add(myhash1);
    while (!pairs.isEmpty()){
    	HashMap<Integer,Integer> pair = pairs.poll();
    	for(Integer key1: pair.keySet())
         key = key1;
    	for(Integer val : pair.values())
         value = val;
        
        if(key.equals(c) &&
                value.equals(d)){
            return "YES";
        }
        int sum=key+value;
        if (sum<=c){
        	HashMap<Integer,Integer> myhash=new HashMap<Integer, Integer>();
        	myhash.put(sum,value);
            pairs.add(myhash);
        }
        if (sum<=d){
        	HashMap<Integer,Integer> myhash=new HashMap<Integer, Integer>();
        	myhash.put(key,sum);
            pairs.add(myhash);
        }

    }

    return "NO";

	}
	
	public static void main(String[] args) {
		System.out.println(pairCheck(2,3,12,1));
	}

}
