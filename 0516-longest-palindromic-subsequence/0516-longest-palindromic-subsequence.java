class Solution {
    public int longestPalindromeSubseq(String s1) {
        int x=s1.length();
        int y=x;
        String s2="";
        for(int i=0;i<x;i++)
        {
            char ch=s1.charAt(i);
            s2=String.valueOf(ch)+s2;
        }
        
        
        
        
        int dp[][]=new int[x+1][y+1];
        for(int i=0;i<=x;i++)
        for(int j=0;j<=y;j++)
        dp[i][j]=-1;
        return call(x-1,y-1,s1,s2,dp);
    }
     public  int call(int x, int y, String s1, String s2,int[][] dp)
    {
        if(x<0||y<0)
        return 0;
        if(dp[x][y]!=-1)
        return dp[x][y];
        if(s1.charAt(x)==s2.charAt(y))
        return dp[x][y]=1+call(x-1,y-1,s1,s2,dp);
        else
        return dp[x][y]=Math.max(call(x-1,y,s1,s2,dp),call(x,y-1,s1,s2,dp));
    }
}