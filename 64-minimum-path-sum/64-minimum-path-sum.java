class Solution {
    public int minPathSum(int[][] arr) {
        int m= arr.length;
        int n = arr[0].length;
        int dp[][]= new int[m][n];
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                dp[i][j]=-1;
          // System.out.println(m+",,,"+n+"  ");
        return call(arr,dp,m-1,n-1);
    }
    public int call(int[][] arr, int[][] dp, int i, int j)
    {          
         if(i==0&&j==0)
            return arr[0][0];
        if(i<0||j<0)
            return 10000000;    
        if(dp[i][j]!=-1)
            return dp[i][j];    
        int a= arr[i][j]+ call(arr,dp,i-1,j);
        int b= arr[i][j]+ call(arr,dp,i,j-1);
        return dp[i][j]=Math.min(a,b);
    }
}