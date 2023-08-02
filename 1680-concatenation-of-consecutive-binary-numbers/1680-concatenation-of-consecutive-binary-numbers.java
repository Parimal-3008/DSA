class Solution {
    public int concatenatedBinary(int n) {
        long mod = 1000000007;
        long ans = 0;
        for(int i=1;i<=n;i++)
        {
            int p = (int)(Math.log((double)i)/Math.log(2.0));
            long temp2 =((long) Math.pow(2,p+1))%mod;
            ans = ((ans*temp2)%mod + (long)i)%mod;
        }
        return (int)ans;
    }
}