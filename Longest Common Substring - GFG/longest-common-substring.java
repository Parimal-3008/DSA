//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            
            String S1 = read.readLine().trim();
            String S2 = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestCommonSubstr(S1, S2, n, m));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int longestCommonSubstr(String str1, String str2, int n, int m){
        // code here
        int[][][] dp = new int[n][m][2];
        for(int i[][]:dp)
        for(int j[]:i)
        Arrays.fill(j,-1);
        return call(0,0,0,str1,str2,dp);
    }
    public int call(int i, int j, int k, String str1, String str2, int[][][] dp)
    {
        if(i==str1.length()|| j==str2.length())
        return 0;
        if(dp[i][j][k]!=-1)
        return dp[i][j][k];
        if(k==1)
        {
            if(str1.charAt(i)==str2.charAt(j))
            return dp[i][j][k]= 1+ call(i+1,j+1,1,str1,str2,dp);
            return 0;
        }
        int a = call(i,j+1,0,str1,str2,dp);
        int b = call(i+1,j,0,str1,str2,dp);
        int c =0;
        if(str1.charAt(i)==str2.charAt(j))
        c = 1+ call(i+1,j+1,1,str1,str2,dp);
        return dp[i][j][k]=Math.max(a,Math.max(b,c));
    }
}