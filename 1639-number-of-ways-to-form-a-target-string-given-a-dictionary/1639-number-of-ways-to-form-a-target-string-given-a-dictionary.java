class Solution {
    long mod = 1000000007;
    public int numWays(String[] arr, String target) {
        int max = 0;
        for(int i=0;i<arr.length;i++)
        {
            max = Math.max(max,arr[i].length());
                       
        }
        int[][] arr2= new int[max][26];
        for(int i=0;i<max;i++)
        {
            for(int j=0;j<arr.length;j++)
            {
                char ch = '.';
                if(i<arr[j].length())
                {
                    ch = arr[j].charAt(i);
                   arr2[i][ch-'a']++;
                }
            }
            
        }
        
        
        long dp[][]= new long[max+1][target.length()+1];
        for(long i[]:dp)
            Arrays.fill(i,-1);
        return (int)call(arr2,target,0,0,dp);
    }
    public long call(int[][] arr, String str, int i, int j, long[][] dp)
    {
        if(j==str.length())
            return 1;
        if(i==arr.length)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        char ch = str.charAt(j);
        long notpick = call(arr,str,i+1,j,dp)%mod;
        long pick = (arr[i][ch-'a']%mod * call(arr,str,i+1,j+1,dp)%mod)%mod;
        return dp[i][j]= (notpick+pick)%mod;
        
    }
    
}