class Solution {
    public int findMaxForm(String[] str, int m, int n) {
        int[][] arr= new int[str.length][2];
        for(int i=0;i<str.length;i++)
        {
            for(char j:str[i].toCharArray())
            {
                if(j=='0')
                    arr[i][0]++;
                else
                    arr[i][1]++;
            }
        }
        int[][][] dp= new int[str.length][m+1][n+1];
        for(int i[][]:dp)
            for(int j[]:i)
                Arrays.fill(j,-1);
        int max = 0;
       
        // return max;
        return call(arr,0,0,0,m,n,dp);
    }
    public int call(int[][] arr, int i,int j, int k, int m, int n, int[][][] dp)
    {
        if(i==arr.length)
            return 0;
        if(dp[i][j][k]!=-1)
            return dp[i][j][k];
        int a = 0;
        if(j+arr[i][0]<=m && k+arr[i][1]<=n)
            a = 1+call(arr,i+1,j+arr[i][0],k+arr[i][1],m,n,dp);
        int b = call(arr,i+1,j,k,m,n,dp);
        return dp[i][j][k]=Math.max(a,b);
         
    }
}