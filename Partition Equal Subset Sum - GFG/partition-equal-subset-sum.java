//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    
    static int equalPartition(int n, int arr[])
    {
        // code here
        int sum = 0;
        for(int i:arr)
        sum+=i;
        if(sum%2==1)
        return 0;
        sum/=2;
        int dp[][]= new int[n][sum+1];
        for(int[] i:dp)
        Arrays.fill(i,-1);
        return call(arr,sum,0,dp);
        
    }
    public static int call(int[] arr,int sum, int i,int[][] dp)
    {
        if(sum == 0)
        return 1;
        if(i==arr.length || sum<0)
        return 0;
        if(dp[i][sum]!=-1)
        return dp[i][sum];
        int a = call(arr,sum-arr[i],i+1,dp);
        int b = call(arr,sum,i+1,dp);
        return dp[i][sum]= a | b;
    }
}