class Solution {
    public int wiggleMaxLength(int[] arr) {
        int dp[][] = new int[arr.length+10][3];
        for(int i=0;i<dp.length;i++)
            Arrays.fill(dp[i],-1);
        return 1+call(0,arr,-1,dp);
        
    }
    public int call(int i, int arr[], int st,int[][] dp)
    {
        if(i==arr.length)
            return 0;
        int a = 0;
        if(dp[i+1][st+1]!=-1)
            return dp[i+1][st+1];
        if(st==-1)
        {
            if(i+1<arr.length)
            {
                if(arr[i]<arr[i+1])
                    a = 1+ call(i+1,arr,1,dp);
                else if(arr[i]>arr[i+1])
                   a = 1+ call(i+1,arr,0,dp);
                
            }
           
        }
        if(st==1)
        {
            if(i+1<arr.length)
            {
                if(arr[i]>arr[i+1])
                   a = 1+ call(i+1,arr,0,dp);
            }
        }
        else
        {
            if(i+1<arr.length)
            {
                if(arr[i]<arr[i+1])
                    a = 1+ call(i+1,arr,1,dp);                
            }            
        }
        int b = call(i+1,arr,st,dp);
        return dp[i+1][st+1]=Math.max(a,b);
    }
}