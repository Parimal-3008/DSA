class Solution {
    public int trailingZeroes(int n) {
        int res=0;
        for(int i=5;i<=n;i*=5)
        {
            res+=(int)(n/i);
        }
        return res;
    }
}