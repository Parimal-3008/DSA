class Solution {
    public int findLength(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int[][][] dp = new int[n][n][2];
        for(int i[][]:dp)
            for(int[]j:i)
            Arrays.fill(j,-1);
        return call(0,0,0,arr1,arr2,dp);
//         for(int i[][]:dp)
//             for(int[]j:i)
//             {
//                 for(int )
//             }
        
    }
    public int call(int i, int j,int k,int[] arr1, int[] arr2,int[][][] dp)
    {
        if(i==arr1.length|| j==arr2.length)
            return 0;
        if(dp[i][j][k]!=-1)
            return dp[i][j][k];
       if(k==1)
       {
           if(arr1[i]==arr2[j])
               return dp[i][j][k]= 1 + call(i+1,j+1,1,arr1,arr2,dp);
           return dp[i][j][k]=0;
           
       }
        int a = call(i,j+1,0,arr1,arr2,dp);
        int c = 0;
        int b = call(i+1,j,0,arr1,arr2,dp);
        if(arr1[i]==arr2[j])
            c= 1 + call(i+1,j+1,1,arr1,arr2,dp);
        return dp[i][j][0] = Math.max(a,Math.max(c,b));
    }
}