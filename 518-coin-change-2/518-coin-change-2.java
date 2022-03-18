class Solution {
    public int change(int k, int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][k+1];
        // for(int i=0;i<n;i++)
        //     for(int j=0;j<=k;j++)
        //         dp[i][j]=-1;
        if(k==0)
            return 1;
        for(int i=0;i<n;i++)
            dp[i][0]=1;
        for(int i=0;i<=k;i++)
           { 
            if(i%arr[0]==0)
                dp[0][i]=1;
           }
        for(int i=01;i<n;i++)
        {
            for(int j=1;j<=k;j++)
            {
                 int not= dp[i-1][j];
                 int pic=0;
                 if(arr[i]<=j)
                    pic=dp[i][j-arr[i]];
                 dp[i][j]=pic+not;
            }
        }
        return dp[n-1][k];
      // return call(arr,dp,k,n-1);;
    }
    public int call(int[] arr, int [][] dp, int k, int i)
    {
        if(i==0)
        {
            if(k%arr[0]==0)
                return 1;
            return 0;
        }
        if(dp[i][k]!=-1)
            return dp[i][k];
        int not= call(arr,dp,k, i-1);
        int pic=0;
        if(arr[i]<=k)
            pic=call(arr,dp,k-arr[i],i);
        
        return dp[i][k]=pic+not;
    }
}