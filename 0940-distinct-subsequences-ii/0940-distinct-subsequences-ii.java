class Solution {
    long mod = 1000000007;
    public int distinctSubseqII(String str) {
        long[] dp= new long[str.length()];
    Arrays.fill(dp,-1l);
        return (int)call(str,0,dp);
    }
    public long call(String str, int i, long[] dp)
    {
        if(i==str.length())
            return 0l;
        if(dp[i]!=-1l)
            return dp[i];
        Set<Character> set = new HashSet<>();
        long ans  = 0;
        for(int j=i;j<str.length();j++)
        {
            char ch = str.charAt(j);
            if(set.contains(ch))
                continue;
            set.add(ch);
            ans =  (ans%mod+ 1 + call(str,j+1,dp)%mod)%mod;
            if(ans<0)
                ans+=mod;
            }
        return dp[i]=ans;
    }
}