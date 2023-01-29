class Solution {
    public int[][] matrixBlockSum(int[][] arr, int k) {
        int ans[][]= new int[arr.length][arr[0].length];
      for(int i=0;i<arr.length;i++)
      {
        int sum =0;
        for(int j=0;j<arr[0].length;j++)
        {
          sum+=arr[i][j];
          ans[i][j]=sum;
          
        }
      }
      int dp[][]= new int[arr.length][arr[0].length];
      for(int i=0;i<arr.length;i++)
      {
        for(int j=0;j<arr[0].length;j++)
        {
          int sum =0;
           for(int p=i-k;p<=i+k;p++)
           {
             if(p<0 || p>= arr.length)
               continue;
             int a = (j+k<arr[0].length?ans[p][j+k]:ans[p][arr[0].length-1]);
             int b = (j-k-1>=0?ans[p][j-k-1]:0);
             // int e1 =Math.min(j+k,arr[0].length);
             sum = sum + a - b ;
           }
          dp[i][j]=sum;
        }
      }
      return dp;
    }
}