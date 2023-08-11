class Solution {
    public int maximalSquare(char[][] arr) {
         int[][] dp = new int[arr.length][arr[0].length];
        for(int i=0;i<arr.length;i++)
        {
            dp[i][0]=(arr[i][0]=='1'?1:0);
        }
         for(int i=0;i<arr[0].length;i++)
        {
            dp[0][i]=(arr[0][i]=='1'?1:0);
        }
        for(int i=1;i<arr.length;i++)
        {
            for(int j=1;j<arr[0].length;j++)
            {
                if(arr[i][j]=='0')
                    dp[i][j]=0;
                else
                    dp[i][j]= 1 + Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]));
            }
        }
        int ans = 0;
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[0].length;j++)
              ans=Math.max(ans,dp[i][j]);
        }
        return ans*ans;
        
    }
}