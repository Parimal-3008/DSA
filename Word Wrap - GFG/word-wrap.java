//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                nums[i]  =Integer.parseInt(S[i]);
            int k = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            System.out.println(obj.solveWordWrap(nums, k));
        }
    }
}

// } Driver Code Ends


class Solution
{
    public int solveWordWrap (int[] arr, int k)
    {
        int[][] dp = new int[arr.length+1][k+1];
        for(int i[]:dp)
        Arrays.fill(i,-1);
       return call(arr,k,0,k,dp);
    }
    public int call(int arr[], int k, int i, int avail,int[][] dp)
    {
        if(i==arr.length)
        return 0;
        if(dp[i][avail]!=-1)
        return dp[i][avail];
        int a = i==arr.length-1?(0):((avail-arr[i])*(avail-arr[i])) + call(arr,k,i+1,k,dp);
            int b = Integer.MAX_VALUE;
            if(i+1<arr.length && arr[i+1]<=avail-arr[i]-1)
            b = call(arr,k,i+1,avail-arr[i]-1,dp);
            // System.out.println(i+" "+avail+" "+a+" "+b);
        return dp[i][avail] = Math.min(a,b);
        
        
    }
}