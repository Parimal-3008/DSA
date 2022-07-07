class Solution {
    public int combinationSum4(int[] arr, int k) {
      int dp[] = new int[1001];
      Arrays.fill(dp,-1);
        return call(arr,k,dp);
    }
    public int call(int[] arr,int k,int[] dp)
      {
      if(k==0)
        return 1;
      if(k<0)
        return 0;
      if(dp[k]!=-1)
        return dp[k];
      int res=0;
      for(int i=0;i<arr.length;i++)
      {
        res += call(arr,k-arr[i],dp);
      }
      return dp[k]=res;
    }
}