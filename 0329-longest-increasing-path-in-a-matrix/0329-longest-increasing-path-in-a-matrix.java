class Solution {
    public int longestIncreasingPath(int[][] arr) {
      int m = arr.length;
      int n = arr[0].length;
      int max = 1;
      int dp[][]= new int[m][n];
      for(int k[]:dp)
           Arrays.fill(k,-1);
       for(int i=0;i<arr.length;i++)
       {
         for(int j=0;j<arr[0].length;j++)
         {
             if(dp[i][j]==-1)
               max = Math.max(max,call(i,j,dp,arr));
           else
             max = Math.max(max,dp[i][j]);           
         }
       }
      return max;
    }
  public int call(int i, int j, int[][] dp, int[][] arr)
  {
    if(i<0 || j<0 || i==arr.length || j== arr[0].length)
      return 0;
     if(dp[i][j]!=-1)
       return dp[i][j];
    int a =1 ;int b = 1; int c =1; int d= 1;
    if(i+1<arr.length && arr[i+1][j]>arr[i][j])
      a = 1 + call(i+1,j,dp,arr);
    if(i-1>=0 && arr[i-1][j]>arr[i][j])
      b =  1+ call(i-1,j,dp,arr);
    if(j+1<arr[0].length && arr[i][j+1]>arr[i][j])
      c = 1 + call(i,j+1,dp,arr);
    if(j-1>=0 && arr[i][j-1]>arr[i][j])
      d = 1 + call(i, j-1,dp,arr);
    return dp[i][j] = Math.max(a,Math.max(b,Math.max(c,d)));
  }
}
