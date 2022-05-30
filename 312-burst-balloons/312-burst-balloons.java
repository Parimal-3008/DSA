class Solution {
    public int maxCoins(int[] arr2) {
        int n = arr2.length;
       int arr[] =new int[n+2];
        arr[0]=1;
        arr[n+1]=1;
        for(int i=1;i<=n;i++)
            arr[i]=arr2[i-1];
        int dp[][] = new int[n+1][n+1];
        for(int i=0;i<=n;i++)
        for(int j=0;j<=n;j++)
            dp[i][j]=-1;
        return call(1,n,arr,dp);
        
    }
    public int call(int start, int end, int[] arr, int[][] dp)
    {
        if(start>end)
            return  0;
        if(dp[start][end]!=-1)
            return dp[start][end];
        int max=-1;
        for(int k= start;k<=end;k++)
        {
                        
           int st=(arr[start-1]*arr[k]*arr[end+1])+call(start,k-1,arr,dp)+call(k+1,end,arr,dp);
           
            max=Math.max(max,st);
        }
        return dp[start][end]=max;
    
    }
   
}