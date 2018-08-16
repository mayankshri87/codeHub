package largestNumberFormedInArray;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class LargestNumberFormedInArray {
	

	  // The main function that prints the 
    // arrangement with the largest value.
    // The function accepts a vector of string
	public void largestNumber(ArrayList<String> list)
	{
		Collections.sort(list, new Comparator<String>() {
		
			// A comparison function which is used by 
	        // sort() in printLargest()
			public int compare(String x, String y)
			{
				String xy = x+y;
				String yx = y+x;
				
				return xy.compareTo(yx) > 0 ? -1:1;
			}
		});
		
		for(int i=0;i<list.size();i++)
		{
			System.out.print(list.get(i));
		}
	}
	
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		
		//output should be 6054854654
        list.add("54");
        list.add("546");
        list.add("548");
        list.add("60");
        
        LargestNumberFormedInArray obj = new LargestNumberFormedInArray();
        
        obj.largestNumber(list);
	}

}
