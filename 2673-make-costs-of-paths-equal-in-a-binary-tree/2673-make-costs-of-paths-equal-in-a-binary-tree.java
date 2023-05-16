class Solution {
    public int minIncrements(int n, int[] arr) {
      int[] dp= new int[n];
        int maxsum =call(0,arr,dp);
        return call2(0,arr,maxsum,dp);
    }
  public int call2(int i, int[] arr, int maxsum,int[] dp)
  {
    if(i>=arr.length)
      return 0;
    int p = maxsum-dp[i];
    int a = call2(2*i+1, arr, maxsum-p-arr[i],dp);
    int b = call2(2*i+2, arr, maxsum-p-arr[i],dp);
    return p+a+b;
    
  }
  public int call(int i,int[] arr,int dp[])
  {
    if(i>=arr.length)
      return 0;
    int a = arr[i]+call(2*i+1, arr, dp);
    int b = arr[i]+call(2*i+2, arr, dp);
    return dp[i]=Math.max(a,b);
  }
}