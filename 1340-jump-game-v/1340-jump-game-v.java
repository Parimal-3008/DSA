class Solution {
    public int maxJumps(int[] arr, int d) {
      int dp[]= new int[arr.length];
      Arrays.fill(dp,-1);
      int  a =0;
      for(int i=0;i<arr.length;i++)
      {
        if(dp[i]==-1)
           a = call(arr,d,i,dp);
      }
      // a = call(arr,d,0,dp);
      int max = -1;
      for(int i:dp){
        // System.out.print(i+" ");
        max = Math.max(max,i);
      }
      // System.out.println();
      return max;
    }
   public int call(int[] arr,int d, int i,int[] dp)
   {
     if(i == arr.length )
       return 0;
     int a = 1; int b = 1;
     if(dp[i]!=-1)
       return dp[i];
     for(int j=1;j<=d;j++)
     {
       boolean flag = false;
       if( i+j<arr.length && arr[i+j]<arr[i] )
          a = Math.max(a, 1+ call(arr,d,i+j,dp));        
       else 
        break;
     }
     for(int j=1;j<=d;j++)
     {
       boolean flag = false;
       if( i-j>=0 && arr[i-j]<arr[i] )
          b = Math.max(b,1 + call(arr,d,i-j,dp));        
       else 
          break;
     }

     return dp[i]=Math.max(a,b);
   }
}