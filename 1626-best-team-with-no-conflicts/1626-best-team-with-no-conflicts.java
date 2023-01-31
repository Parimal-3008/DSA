class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
      int arr[][]= new int[n][2];
      for(int i=0;i<n;i++)
      {
        arr[i][0]=ages[i];
        arr[i][01]=scores[i];
      }
      Arrays.sort(arr,new Comparator<int[]>(){
        public int compare(int[] a, int[] b)
        {
          int res = Integer.compare(a[0],b[0]);
          if(res ==  0)
            res = Integer.compare(a[1],b[1]);
          return res;
        }
        
      });
      int[][] dp= new int[n+1][n+1];
      for(int i[]:dp)
        Arrays.fill(i,-1);
      // for(int i=0;i<n;i++)
      // {
      //   System.out.print(arr[i][0]+" ");
      // }
      // System.out.println();
      // for(int i=0;i<n;i++)
      // {
      //   System.out.print(arr[i][1]+" ");
      // }
      //  System.out.println();
      return call(0,-1,arr,dp);
    }
  public int call(int i, int prev, int[][] arr, int[][] dp)
  {
    if( i== arr.length)
      return 0;
    if(dp[i][prev+1]!=-1)
      return dp[i][prev+1];
    if(prev == -1)
    {
      int a = arr[i][1]+call(i+1,i,arr,dp);
      int b = call(i+1,prev,arr,dp);
      return dp[i][prev+1]= Math.max(a,b);
    }
    else
    {
      int a = 0; int b=0;
      if(arr[i][1]>=arr[prev][1] ||( arr[i][0]==arr[prev][0] && arr[i][1]>=arr[prev][1]))
      {
          a = arr[i][1]+call(i+1,i,arr,dp);
            b = call(i+1,prev,arr,dp);
      }
      else
        a = call(i+1,prev,arr,dp);
      return dp[i][prev+1]=Math.max(a,b);
    }
  }
}