package hackerRank;

import java.sql.Date;
import java.util.HashMap;

public class CustomerTime {
	
	HashMap<Integer, HashMap<String,Date>> cust=new HashMap<>();
	
	public boolean search(int custID, int prodID, Date date)
	{	long time=0;;
		if(cust.containsKey(custID))
			if(cust.get(custID).containsKey(prodID))
				if(cust.get(custID).get(prodID).before(date))
					time = cust.get(custID).get(prodID).getTime() - date.getTime();
		
		if(time/(1000*60*60) >24 )
			return true;
		return false;
	}

}
