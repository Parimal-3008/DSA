class Solution {
    public int minFallingPathSum(int[][] arr) {
        int n =arr.length;
        int dp[][] = new int[n][n];
        // for(int i=0;i<n;i++)
        // {
        //    for(int j=0;j<n;j++)
        //        dp[i][j]=-1;
        // }
        for(int i=n-1;i>=0;i--)
        {
            for(int j=n-1;j>=0;j--)
            {
                if(i==n-1)
                {dp[i][j]=arr[i][j];continue;}
                int a=Integer.MAX_VALUE;int b=Integer.MAX_VALUE;int c=Integer.MAX_VALUE;
                if(i+1<n)
                    a=arr[i][j]+dp[i+1][j];               
                if(i+1<n&&j+1<n)
                    b=arr[i][j]+dp[i+1][j+1];
                if(i+1<n&&j-1>=0)
                    c=arr[i][j]+dp[i+1][j-1];
                dp[i][j]=Math.min(a,Math.min(b,c));
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
            min = Math.min(min,dp[0][i]);
        return min;
            
    }
    /*
    as recurrsion satrted from 0,i so tabulation will start from n-1,i
    */
    public int call(int[][] arr, int[][] dp, int i, int j)
    {
        int n= arr.length;
        if(j<0||j==n)
            return 10000000;
        if(i==n-1)
            return arr[i][j];
        if(dp[i][j]!=-1)
            return dp[i][j];
        int a =arr[i][j]+call(arr,dp,i+1,j);
        int b =arr[i][j]+call(arr,dp,i+1,j+1);
        int c=arr[i][j]+call(arr,dp,i+1,j-1);
        //System.out.println(Math.min(a,Math.min(b,c)));
        return dp[i][j]= Math.min(a,Math.min(b,c));
    }
}