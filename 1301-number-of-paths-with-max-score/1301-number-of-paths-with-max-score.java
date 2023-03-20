class Solution {
  int mod = 1000000007;
    public int[] pathsWithMaxScore(List<String> list) {
        int m = list.size();
      int n = list.get(0).length();
      int arr[][]= new int[m][n];
      for(int i=0;i<m;i++)
      {
        String str = list.get(i);
        for(int j=0;j<n;j++)
        {
          char ch = str.charAt(j);
          if(ch=='X')
            arr[i][j]=-1;
          else if(ch=='E' || ch=='S')
            arr[i][j]=0;
          else
            arr[i][j]=Integer.parseInt(String.valueOf(ch));
        }
      }
      int ans[]={0,0};
      int dp[][]= new int[m][n];
      for(int i[]:dp)
        Arrays.fill(i,-1);
      int p= call(ans,arr,dp,0,0);
      if(dp[m-1][n-1]==-1)
        return new int[2];
      // for(int i[]:dp)
      // {
      //   for(int j:i)
      //     System.out.print(j+" ");
      //   System.out.println();
      // }
      ans[1]=1;
     int[][][] dp2= new int[m][n][1801];
      for(int i[][]:dp2)
        for(int j[]:i)
        Arrays.fill(j,-1);
      ans[1]= call2(ans[0],arr,dp2,0,0);
      
      return ans;
    }
  public int call2(int n,int[][] arr,int[][][] dp,int i, int j)
  {
     if(i==arr.length-1 && j == arr[0].length-1)
     {
       if(n==0)
         return 1;
       return 0;
     }
    if(n<0)
      return 0;
    if(dp[i][j][n]!=-1)
      return dp[i][j][n];
    if(i==arr.length || j== arr[0].length)
       return 0;
      int a =0;int b =0; int c =0;
     if(i+1<arr.length && arr[i+1][j]!=-1)
       a = call2(n-arr[i][j],arr,dp,i+1,j)%mod;
     if(j+1<arr[0].length && arr[i][j+1]!=-1)
       b = call2(n-arr[i][j],arr,dp,i,j+1)%mod;
     if(i+1<arr.length && j+1<arr[0].length && arr[i+1][j+1] !=-1)
        c = call2(n-arr[i][j],arr,dp,i+1,j+1)%mod;
    while(a<0) a+=mod; while(b<0) b+=mod; while(c<0) c+=mod;
     dp[i][j][n]=((a+b)%mod+c)%mod;
    while(dp[i][j][n]<0)
      dp[i][j][n]+=mod;
    return dp[i][j][n];
  }
   public int call(int[] ans,int[][] arr,int[][] dp, int i, int j)
   {
     if(i==arr.length-1 && j == arr[0].length-1)
     {
       if(ans[1]==0)
         ans[1]=1;
       return dp[i][j]=0;
     }
     if(i==arr.length || j== arr[0].length)
       return 0;
     if(dp[i][j]!=-1)
       return dp[i][j];
    int a =0;int b =0; int c =0;
     if(i+1<arr.length && arr[i+1][j]!=-1)
       a = arr[i][j]+call(ans,arr,dp,i+1,j);
     if(j+1<arr[0].length && arr[i][j+1]!=-1)
       b = arr[i][j]+call(ans,arr,dp,i,j+1);
     if(i+1<arr.length && j+1<arr[0].length && arr[i+1][j+1] !=-1)
        c = arr[i][j]+call(ans,arr,dp,i+1,j+1);
     
    if(ans[0]<Math.max(a,Math.max(b,c))){
        ans[0]=Math.max(a,Math.max(b,c));
       ans[1]=1;
     }
     else if(ans[0]==Math.max(a,Math.max(b,c)))
       ans[1]= (ans[1]+1)%mod;
     return dp[i][j]=Math.max(a,Math.max(b,c));
     
   }
}