class Solution {
    public boolean hasValidPath(char[][] grid) {
        int arr[][]= new int[grid.length][grid[0].length];
      for(int i=0;i<grid.length;i++)
      {
        for(int j=0;j<grid[i].length;j++)
        {
          if(grid[i][j]=='(')
            arr[i][j]=1;
          else
            arr[i][j]=-1;
        }
      }
      int dp[][][]= new int[105][105][250];
      for(int i[][]:dp)
        for(int j[]:i)
        Arrays.fill(j,-1);
      int ans =  call(arr,0,0,0,dp);
      if(ans==0)
        return false;
      return true;
    }
   public int call(int[][] arr, int i, int j,int res,int dp[][][])
   {
    if(res<0)
      return 0;
     if(i == arr.length-1 && j== arr[0].length-1)
     {
         if(res+arr[i][j]==0)
             return  1;
        return 0;
     }
     if(i>=arr.length|| j >= arr[0].length)
       return 0;
     if(dp[i][j][res]!=-1)
     {
      return dp[i][j][res];
     }
    
     int a = call(arr,i+1,j,res+arr[i][j],dp);
     int b = call(arr,i,j+1,res+arr[i][j],dp);
     
     return dp[i][j][res]=a+b;
   }
}