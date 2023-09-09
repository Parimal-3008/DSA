class Solution {
    long mod = 1000000007;
    public int countRoutes(int[] arr, int start, int finish, int fuel) {
        long dp[][]= new long[fuel+1][arr.length+1];
        for(long i[]:dp)
            Arrays.fill(i,-1);
        return (int)call(arr,start,fuel,finish,dp);
    }
    public long call(int[] arr, int i, int fuel, int finish,long[][] dp)
    {
        if(fuel<0)
            return 0;
        long ans = 0;
        if(dp[fuel][i]!=-1)
            return dp[fuel][i];
        if(i==finish && fuel>=0)
            ans++;
        for(int j=0;j<arr.length;j++)
        {
            if(j==i)
                continue;
            if(fuel-Math.abs(arr[i]-arr[j])>=0)
             ans =( ans% mod + call(arr,j,fuel-Math.abs(arr[i]-arr[j]),finish,dp)%mod)%mod;
        }
            return dp[fuel][i] = ans;
    }
}