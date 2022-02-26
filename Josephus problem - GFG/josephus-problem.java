// { Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Recursion {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();//testcases
		while(T-->0)
		{
		    Solution obj=new Solution();
		    
		    int n,k;
		    //taking input n and k
		    n=sc.nextInt();
		    k=sc.nextInt();
		    
		    //calling josephus() function
		    System.out.println(obj.josephus(n,k));
		    
		    
		}
		
	}
}

// } Driver Code Ends


class Solution
{
   public int josephus(int n, int k)
    {
       ArrayList<Integer> list = new ArrayList<>();
        for(int i=1;i<=n;i++)
        list.add(i);
       
        int j=(k-1)%n;
        while(list.size()>1)
        {
            int p= list.size();
            //System.out.println(list);
            int po=j;
            list.remove(j);
            j=(po+k-1)%(p-1);
           
            
            
            
        }
        //System.out.println(list);
        return list.get(0);
    }

}

