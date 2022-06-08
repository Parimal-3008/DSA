class Solution {
    public int minSideJumps(int[] arr) {
        int[][][] dp= new int[arr.length][3][2];
        for(int i=0;i<dp.length;i++)
            for(int j=0;j<dp[i].length;j++)
            {
                dp[i][j][0]=-1;
                dp[i][j][1]=-1;
            }
        return call(0,2,0,arr,dp);
        
    }
    public int call(int i,int j,int st,int[] arr,int[][][] dp)
    {
        if(i==arr.length)
            return 0;
        if(arr[i]==j)
            return Integer.MAX_VALUE-10000;
        int[] arr2 = new int[3];
        Arrays.fill(arr2,Integer.MAX_VALUE);
        if(dp[i][j-1][st]!=-1)
            return dp[i][j-1][st];
        
        arr2[0]=call(i+1,j,0,arr,dp);     
        if(st==0)
        {
            if(j==1)
            {
                arr2[1]=1+call(i,2,1,arr,dp);
                arr2[2]=1+call(i,3,1,arr,dp);
            }
            if(j==2)
            {
                arr2[1]=1+call(i,1,1,arr,dp);
                arr2[2]=1+call(i,3,1,arr,dp);
            }
            if(j==3)
            {
                arr2[1]=1+call(i,2,1,arr,dp);
                arr2[2]=1+call(i,1,1,arr,dp);
            }
        }
        int min=Integer.MAX_VALUE;
        for(int k:arr2)
            if(k<min)
                min=k;
        return dp[i][j-1][st]=min;
        
         
        
        
       
    }
}