class Solution {
    public int maxPalindromes(String str, int k) {
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
        return call(str,k,0,0,dp,dp2);
    }
    public int call(String str, int k, int i, int prev, int[][] dp, int[][] dp2)
    {
        if(i==str.length()-1)
        {
            if(dp[prev][i]==1 && i-prev+1>=k)
                return 1;
            return 0;
            
        }
        if(dp2[prev][i]!=-1)
            return dp2[prev][i];
        int a = 0; int b = 0;int c = 0;
        if(dp[prev][i]==1 && i-prev+1>=k)
            a= 1+ call(str,k,i+1,i+1,dp,dp2);
        b = call(str,k,i+1,prev,dp,dp2);
        c = call(str,k,i+1,i+1,dp,dp2);
        return dp2[prev][i]=Math.max(Math.max(c,a),b);
    }
}