class Solution {
    public int[] countBits(int n) {
      int[] res = new int[n+1];
        for(int i = 0;i <= n;i++)
            res[i] = solve(i,res);
        return res;
    }
    public static int solve(int n, int[] memo) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(memo[n] != 0) return memo[n];
        if(n % 2 == 0)
            memo[n] = solve(n/2, memo);    
        else
            memo[n] = solve(n/2,memo) + 1;
        return memo[n];
    }
}