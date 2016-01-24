package hackerRank;

import java.util.ArrayList;

public class complement {
static int getIntegerComplement(int n) {
        
        String binary=Integer.toBinaryString(n);
        StringBuilder strb=new StringBuilder();
        for(char ch: binary.toCharArray())
        	if (ch=='0')
        		strb.append('1');
        	else
        		strb.append('0');
        return Integer.parseInt(strb.toString(),2);


    }

    
    public static void main(String[] args) {
		System.out.println(getIntegerComplement(50));
	}
}


