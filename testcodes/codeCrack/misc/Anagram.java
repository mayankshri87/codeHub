package misc;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Anagram {

	public static int numberNeeded(String first, String second) {
	     
        int[] hash_first = new int[256];
        int[] hash_second = new int[256];
        int count = 0;
        for(int i = 0 ; i<first.length() ; i++)
        {
            hash_first[first.charAt(i)]++;
        }
        
        for(int j = 0 ; j<second.length();j++)
        {
            hash_second[second.charAt(j)]++;
        }
        
        for(int k = 0 ; k<first.length();k++)
        {
            if(hash_second[first.charAt(k)]==0 || (hash_second[first.charAt(k)]>0 && hash_second[first.charAt(k)]>hash_first[first.charAt(k)]))
            {
                count++;
                hash_first[first.charAt(k)]--;
            }
        }
        
        for(int k = 0 ; k<second.length();k++)
        {
            if(hash_first[second.charAt(k)]==0 || (hash_first[second.charAt(k)]>0 && hash_first[second.charAt(k)]>hash_first[second.charAt(k)]))
            {
                count++;
                hash_second[second.charAt(k)]--;
            }
        }
        
        return count;
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a.toLowerCase(), b.toLowerCase()));
    }

}
