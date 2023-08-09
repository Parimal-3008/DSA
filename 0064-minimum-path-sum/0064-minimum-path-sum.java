class Solution {
    public int minPathSum(int[][] arr) {
       int[][] dp= new int[arr.length][arr[0].length];
        for(int i[]:dp)
            Arrays.fill(i,-1);
        return call(0,0,arr,dp);
    }
    public int call(int i, int j, int[][] arr, int[][] dp)
    {
        if(i==arr.length ||j==arr[0].length)
            return Integer.MAX_VALUE-10000;
          if(i==arr.length-1 &&j==arr[0].length-1)
              return arr[i][j];
        if(dp[i][j]!=-1)
            return dp[i][j];
        int a = arr[i][j]+ call(i+1,j,arr,dp);
        
        int b= arr[i][j]+ call(i,j+1,arr,dp);
        
        return dp[i][j]=Math.min(a,b);
    }
}