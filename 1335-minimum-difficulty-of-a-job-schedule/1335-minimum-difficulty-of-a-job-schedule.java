class Solution {
    public int minDifficulty(int[] arr, int d) {
        int[][] dp = new int[arr.length+1][d+1];
        for(int i[]:dp)
            Arrays.fill(i,-1);
       int ans =  call(arr,d,0,0,dp);
        return ans>300000?-1:ans;
    }
    public int call(int[] arr, int d, int i, int j,int[][] dp)
    {
        if(i==arr.length && d==j)
            return 0;
        if(j>d || i==arr.length)
            return Integer.MAX_VALUE-100000;
        if(dp[i][j]!=-1)
            return dp[i][j];
        int ans = Integer.MAX_VALUE;
        int max = arr[i];
        for(int k=i;k<arr.length;k++)
        {
            max = Math.max(max,arr[k]);
            int temp = max+ call(arr,d,k+1,j+1,dp);
            ans = Math.min(ans,temp);
        }
        return dp[i][j]=ans;
    }
}