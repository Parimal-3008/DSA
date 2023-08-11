//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.getCount(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
	public long getCount(int n)
	{
		// Your code goes here
		List<List<Integer>> list = new ArrayList<>();
		for(int i=0;i<=9;i++)
		list.add(new ArrayList<>());
		list.get(0).add(0);list.get(0).add(8);
		list.get(7).add(7);list.get(7).add(4);list.get(7).add(8);
		list.get(8).add(7);list.get(8).add(8);list.get(8).add(9);list.get(8).add(5);list.get(8).add(0);
		list.get(9).add(9);list.get(9).add(8);list.get(9).add(6);
		list.get(4).add(1);list.get(4).add(4);list.get(4).add(5);list.get(4).add(7);
		list.get(5).add(4);list.get(5).add(5);list.get(5).add(6);list.get(5).add(2);list.get(5).add(8);
		list.get(6).add(3);list.get(6).add(5);list.get(6).add(6);list.get(6).add(9);
		list.get(3).add(3);list.get(3).add(2);list.get(3).add(6);
		list.get(2).add(3);list.get(2).add(2);list.get(2).add(1);list.get(2).add(5);
		list.get(1).add(1);list.get(1).add(2);list.get(1).add(4);
		long[][] dp= new long[n][11];
		for(long i[]:dp)
		Arrays.fill(i,-1l);
		return call(0,-1,n,list,dp);
	}
	public long call(int i, int j,int n,List<List<Integer>> list, long[][] dp)
	{
	    if(i==n)
	    return 1l;
	    if(dp[i][j+1]!=-1)
	    return dp[i][j+1];
	    if(j==-1)
	    {
	        long ans = 0;
	        for(int k=0;k<=9;k++)
	          ans += call(i+1,k,n,list,dp);
	          return dp[i][j+1]= ans;
	    }
	    long ans = 0;
	    for(int k:list.get(j))
	     ans += call(i+1,k,n,list,dp);
	   return dp[i][j+1]= ans;
	}
}