class Solution {
    public int minFallingPathSum(int[][] arr) {
        
        int[][] dp= new int[arr.length][arr[0].length+10];
        for(int[] i:dp)
            Arrays.fill(i,-1);
        return call(arr,0,-1,dp);
    }
    public int call(int[][] arr, int i, int j,int[][] dp)
    {
        if(i==arr.length)
        return 0;
        int ans = Integer.MAX_VALUE;
        if(dp[i][j+1]!=-1)
            return dp[i][j+1];
        for(int k=0;k<arr[0].length;k++)
        {
            if(k==j)
                continue;
            ans = Math.min(ans, arr[i][k]+call(arr,i+1,k,dp));            
        }
        return dp[i][j+1]=ans;
        
    }
}