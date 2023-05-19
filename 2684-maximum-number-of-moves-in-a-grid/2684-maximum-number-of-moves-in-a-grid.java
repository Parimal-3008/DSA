class Solution {
    public int maxMoves(int[][] arr) {
        int dp[][]= new int[arr.length][arr[0].length];
      for(int i[]:dp)
        Arrays.fill(i,-1);
      int max = 0;
      for(int i=0;  i<arr.length;i++)
      {
       
        {
          max = Math.max(max,call(i,0,arr,dp));
        }
      }
      return max;
    }
  public int call(int i, int j, int[][] arr, int[][] dp)
  {
    if(i==arr.length|| j==arr[0].length|| i<0)
      return 0;
    if(dp[i][j]!=-1)
      return dp[i][j];
    int a = 0;int b = 0; int c =0;
    if(i-1>=0 && j+1<arr[0].length && arr[i][j]<arr[i-1][j+1])
      a = 1 + call(i-1,j+1,arr,dp);
    if( j+1<arr[0].length && arr[i][j]<arr[i][j+1])
     b = 1 + call(i,j+1,arr,dp);
    if(i+1<arr.length && j+1<arr[0].length && arr[i][j]<arr[i+1][j+1])
      c = 1 + call(i+1,j+1,arr,dp);
    return dp[i][j]= Math.max(a,Math.max(b,c));
    
  }
}