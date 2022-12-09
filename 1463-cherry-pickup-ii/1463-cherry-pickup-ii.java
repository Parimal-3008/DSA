class Solution {
    public int cherryPickup(int[][] arr) {
      int m = arr.length;
      int n = arr[0].length;
      int dp[][][][] = new int[m+1][n+1][m+1][n+1];
      for(int i[][][]:dp)
      {
        for(int j[][]:i)
          for(int k[]:j)
            Arrays.fill(k,-1);
      }
        return call(arr,0,0,0,n-1,dp);
    }
  public int call(int[][] arr, int i, int j, int k, int l,int[][][][] dp)
  {
    if(i==arr.length|| k == arr.length || j<0 ||j== arr[0].length || l<0 ||l== arr[0].length)
      return 0;
    int ans[]= new int[9];
    if(dp[i][j][k][l]!=-1)
      return dp[i][j][k][l];
    if(j!=l)
   { 
      ans[0]= arr[i][j]+arr[k][l]+call(arr,i+1,j-1,k+1,l-1,dp);
    ans[1]= arr[i][j]+arr[k][l]+call(arr,i+1,j-1,k+1,l,dp);
    ans[2]= arr[i][j]+arr[k][l]+call(arr,i+1,j-1,k+1,l+1,dp);
    ans[3]= arr[i][j]+arr[k][l]+call(arr,i+1,j,k+1,l-1,dp);
    ans[4]= arr[i][j]+arr[k][l]+call(arr,i+1,j,k+1,l,dp);
    ans[5]= arr[i][j]+arr[k][l]+call(arr,i+1,j,k+1,l+1,dp);
    ans[6]= arr[i][j]+arr[k][l]+call(arr,i+1,j+1,k+1,l-1,dp);
    ans[7]= arr[i][j]+arr[k][l]+call(arr,i+1,j+1,k+1,l,dp);    
    ans[8]= arr[i][j]+arr[k][l]+call(arr,i+1,j+1,k+1,l+1,dp);
   }
    else
    {
        ans[0]= arr[i][j]+call(arr,i+1,j-1,k+1,l-1,dp);
    ans[1]= arr[i][j]+call(arr,i+1,j-1,k+1,l,dp);
    ans[2]= arr[i][j]+call(arr,i+1,j-1,k+1,l+1,dp);
    ans[3]= arr[i][j]+call(arr,i+1,j,k+1,l-1,dp);
    ans[4]= arr[i][j]+call(arr,i+1,j,k+1,l,dp);
    ans[5]= arr[i][j]+call(arr,i+1,j,k+1,l+1,dp);
    ans[6]= arr[i][j]+call(arr,i+1,j+1,k+1,l-1,dp);
    ans[7]= arr[i][j]+call(arr,i+1,j+1,k+1,l,dp);    
    ans[8]= arr[i][j]+call(arr,i+1,j+1,k+1,l+1,dp);
    }
    int max =-1;
    for(int p=0;p<9;p++)
      max = Math.max(max,ans[p]);
    return  dp[i][j][k][l]=max;
   
  }
}