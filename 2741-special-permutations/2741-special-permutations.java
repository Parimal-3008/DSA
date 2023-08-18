class Solution {
    long mod = 1000000007;
    public int specialPerm(int[] arr) {
        long[][] dp= new long[35000][arr.length+1];
        for(long i[]:dp)
            Arrays.fill(i,-1);
        long ans = 0;
        char[] arr2= new char[arr.length];
        Arrays.fill(arr2,'0');
        for(int i=0;i<arr.length;i++)
        {
            // System.out.println((int)Math.pow(2,i+1)+" "+i);
            arr2[i]='1';
            ans= (ans%mod + call(arr2,i,arr,dp)%mod)%mod;
            arr2[i]='0';
        }
        return (int)ans;
    }
    public long call(char[] arr, int prev, int[] arr2,long[][] dp)
    {
       String str= new String(arr);
        int mask = Integer.parseInt(str,2);
        if(dp[mask][prev]!=-1)
            return dp[mask][prev];
        long ans = 0;
        int count = 0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]=='1')
            {
                count++;
             continue;
            }
            // System.out.println(str+" "+prev+" "+i);
            if(arr2[i]%arr2[prev]==0 || arr2[prev]%arr2[i]==0)
           { 
                arr[i]='1';
               ans = (ans%mod + call(arr,i,arr2,dp)%mod)%mod;
               arr[i]='0';
           }
        }
        if(count == arr.length)
            return dp[mask][prev]=1l;
        return dp[mask][prev]=ans;
    }
}