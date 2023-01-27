class Solution {
    public int closedIsland(int[][] arr)  {
        int m = arr.length;
      int n = arr[0].length;
      int ans =0;
      boolean[][] vis= new boolean[m][n];
      for(int i=0;i<m;i++)
      {
        for(int j=0;j<n;j++)
        {
          if(arr[i][j]==0 && !vis[i][j])
          {
           int p = call(i,j,m,n,arr,vis);
            if(p==0)
              ans++;
          }
        }
      }
      return ans;
    }
  public int call(int i, int j, int m, int n, int[][] arr,boolean[][] vis)
  {
    if(i<0 || i==m || j<0 || j==n)
      return 0;
    if(vis[i][j])
      return 0;
    if(arr[i][j]==1)
      return 0;
    if(arr[i][j]==0 && (i==0 ||j == 0 || i == m-1 || j==n-1))
      return 1;
    vis[i][j]=true;
    int a = call(i+1,j,m,n,arr,vis);
    int b = call(i,j+1,m,n,arr,vis);
    int c = call(i-1,j,m,n,arr,vis);
    int d = call(i,j-1,m,n,arr,vis);
    return a | b | c | d ;
    
    
  }
}