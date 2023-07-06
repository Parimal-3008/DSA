//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new Solution().smallestWindow(s, t));
		    test--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String str1, String str2)
    {
        int[] arr1= new int[26];
        int[] arr2= new int[26];
        for(int i=0;i<str2.length();i++)
        {
            char ch = str2.charAt(i);
           arr2[(int)ch -'a']++;
            
        }
        int j=0;
        TreeMap<Integer,Integer> mp = new TreeMap<>();
        for(int i=0;i<str1.length();i++)
        {
             char ch = str1.charAt(i);
           arr1[(int)ch -'a']++;
           boolean p = check(arr2,arr1);
           while(p)
           {
               int len = i-j+1;
               if(!mp.containsKey(len))
               mp.put(len,j);
               ch = str1.charAt(j);
               arr1[(int)ch -'a']--;
               j++;
               p = check(arr2,arr1);
               
               
           }
        }
        // System.out.println(mp);
        if(mp.isEmpty())
        return "-1";
        int len = mp.firstKey();
        return str1.substring(mp.get(len),mp.get(len)+len);
        // Your code here
        
    }
    public static boolean check(int[] arr1,int[] arr2)
    {
        for(int i=0;i<26;i++)
        {
            if(arr1[i]>arr2[i])
            return false;
        }
        return true;
    }
}