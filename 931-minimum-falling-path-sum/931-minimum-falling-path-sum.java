class Solution {
    public int minFallingPathSum(int[][] arr) {
        int n= arr.length;
        int dp[][] = new int[n][n];
         for(int i=0;i<n;i++)
             for(int j=0;j<n;j++)
                 dp[i][j]=Integer.MAX_VALUE;
       
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==0)
                {dp[i][j]=arr[i][j];continue;}
                 int a=arr[i][j];int c=arr[i][j];int b=arr[i][j];
                if(i-1>=0)
                    a+=dp[i-1][j];
                else
                    a+=100000000;
                if(i-1>=0&&j-1>=0)
                    b+=dp[i-1][j-1];
                else
                    b+=100000000;
                if(i-1>=0&&j+1<n)
                    c+=dp[i-1][j+1];
                else
                    c+=100000000;
               dp[i][j]=Math.min(a,Math.min(b,c));
            }
        }
        int min=Integer.MAX_VALUE;
        
        for(int i=0;i<n;i++)
            min=Math.min(min,call(arr,dp,n-1,i));
        // for(int i=0;i<n;i++)
        // {
        //     for(int j=0;j<n;j++)
        //         System.out.print(dp[i][j]+" ");
        //     System.out.println();
        // }
        return min;
    }
    public int call(int[][] arr, int[][] dp, int i, int j)
    {
        if(i<0||j<0||j==arr.length)
            return 100000000;
        if(i==0)
            return arr[i][j];
        if(dp[i][j]!=-1)
            return dp[i][j];
        int a=arr[i][j];int c=arr[i][j];
        int b=arr[i][j];
        
            a+=call(arr,dp,i-1,j-1);
            b+=call(arr,dp,i-1,j);
            c+=call(arr,dp,i-1,j+1);
        return dp[i][j]=Math.min(a,Math.min(b,c));
    }
}