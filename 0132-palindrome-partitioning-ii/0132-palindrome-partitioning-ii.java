class Solution {
    public int minCut(String str) {
         int n = str.length();
        int[][] dp = new int[n][n];
        
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (i >= j)
                    dp[i][j] = 1;
                else if (str.charAt(i) == str.charAt(j))
                    dp[i][j] = dp[i + 1][j - 1];
            }
        }
        int[][] dp2 = new int[n+1][n+1];
        for(int i[]:dp2)
            Arrays.fill(i,-1);
        return call(str,0,0,dp,dp2)-1;
    }
    public int call(String str, int i, int prev, int[][] dp, int[][] dp2)
    {
        if(i==str.length()-1)
        {
            if(dp[prev][i]==1 )
                return 1;
            return 100000;
        }
        if(dp2[prev][i]!=-1)
            return dp2[prev][i];
        int a = 100000; int b = 1000000;
        if(dp[prev][i]==1 )
            a= 1+ call(str,i+1,i+1,dp,dp2);
        b = call(str,i+1,prev,dp,dp2);
       
        return dp2[prev][i]=Math.min(a,b);
    }
}