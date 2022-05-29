class Solution {
    public int minCost(int m, int[] arr2) {
        Arrays.sort(arr2);int n = arr2.length;
        int arr[] = new int[n+2];
        arr[0]=0;arr[n+1]=m;
        for(int i=1;i<n+1;i++)
            arr[i]=arr2[i-1];
       
        int dp[][] = new int[n+1][n+1];
        for(int i=0;i<=n;i++ )
            for(int j=0;j<=n;j++)
                dp[i][j]=-1;
        return call(1,arr2.length,arr,dp);
    }
    public int call(int start, int end,int[] arr, int[][] dp)
    {
        if(start>end)
            return 0;
        if(dp[start][end]!=-1)
            return dp[start][end];
        int min=Integer.MAX_VALUE;
        for(int k=start;k<=end;k++)
        {
        int st= arr[end+1]-arr[start-1]+call(start,k-1,arr,dp)+call(k+1,end,arr,dp);
            min=Math.min(min,st);
        }
        return dp[start][end]=min;
    }
}