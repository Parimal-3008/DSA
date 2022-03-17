class Solution {
    public int coinChange(int[] arr, int k) {
        int n = arr.length;
        int[][] dp = new int[n][k+1];
        for(int i=0;i<n;i++)
            for(int j=0;j<=k;j++)
                dp[i][j]=-1;
        if(k==0)
            return 0;
        int p =call(arr,dp,k,n-1);
         // for(int i=0;i<n;i++)
         //   { 
         //     for(int j=0;j<=k;j++)
         //        System.out.print(dp[i][j]+" ");
         //     System.out.println();
         //    }

        if(p==Integer.MAX_VALUE-1)
            return -1;
        return p;
    }
    public int call(int[] arr, int [][] dp, int k, int i)
    {
        if(i==0)
        {
            if(k%arr[0]==0)
                return k/arr[0];
            return Integer.MAX_VALUE-1;
        }
        if(dp[i][k]!=-1)
            return dp[i][k];
        int not= call(arr,dp,k, i-1);
        int pic=Integer.MAX_VALUE;
        if(arr[i]<=k)
            pic=1+call(arr,dp,k-arr[i],i);
        
        return dp[i][k]=Math.min(not,pic);
    }
}