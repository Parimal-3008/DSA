class Solution {
    public long mostPoints(int[][] arr) {
        long dp[] =new long[arr.length];
        Arrays.fill(dp,-1);
        return call(arr,0,dp);
        
    }
    public long call(int[][] arr, int i,long[] dp)
    {
        if(i>=arr.length)
            return 0;
        if(dp[i]!=-1)
            return dp[i];
        long p = (long)arr[i][0]+ call(arr,i+arr[i][1]+1,dp);
        long q =  call(arr,i+1,dp);
      //  System.out.println(p+"."+q);
        return dp[i]=Math.max(p,q);

    }
}