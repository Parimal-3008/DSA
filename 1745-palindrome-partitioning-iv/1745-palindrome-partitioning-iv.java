class Solution {
    public boolean checkPartitioning(String str) {
        int[][] dp = new int[str.length()][str.length()];
        int[][] dp2 = new int[str.length()][4];
        int n = str.length();
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (i >= j)
                    dp[i][j] = 1;
                else if (str.charAt(i) == str.charAt(j))
                    dp[i][j] = dp[i + 1][j - 1];
            }
        }
        for(int i[]:dp2)
            Arrays.fill(i,-1);
        // System.out.println(">............");
        return call(str,0,3,dp,dp2) == 1;
        
    }
    public int call(String str, int i, int k,int[][] dp, int[][] dp2)
    {
        if(i==str.length())
            return k==0?1:0;
        if(k<=0)
            return 0;
        if(dp2[i][k]!=-1)
            return dp2[i][k];
        int ans =0;
        for(int j=i;j<str.length();j++)
        {
            // System.out.println(i+" "+j+" "+dp[i][j]);
            if(dp[i][j]==1)
            {
                // System.out.println(i+" "+j);
                ans = ans | call(str,j+1,k-1,dp,dp2);
            }
        }
        return dp2[i][k]=ans;
        
    }
   
}