class NumMatrix {
    int[][] dp; 
    public NumMatrix(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        dp= new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
                dp[i][j]=(j==0?arr[i][j]:arr[i][j]+dp[i][j-1]);
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                dp[j][i]=(j==0?dp[j][i]:dp[j-1][i]+dp[j][i]);
            }
        }
        // for(int i[]:dp)
        // {
        //     for(int j:i)
        //         System.out.print(j+" ");
        //     System.out.println();
        // }
    }
    
    public int sumRegion(int r1, int c1, int r2, int c2) {
        int sum = dp[r2][c2];
        if(c1!=0)
            sum-=dp[r2][c1-1];
        int temp = 0;
        if(r1>0 && c1>0)
       { 
            sum+=dp[r1-1][c1-1];
          
        }
        if(r1-1>=0)
             sum-=dp[r1-1][c2];
        return sum;
        
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */