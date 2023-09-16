class Solution {
    public int minHeightShelves(int[][] books, int k) {
        int[] dp = new int[books.length];
        Arrays.fill(dp,-1);
        return call(books,k,0,dp);
    }
    public int call(int[][] arr, int k, int i,int[] dp)
    {
        if(i==arr.length)
            return 0;
        int a = 0;int b = 0;
        int max = Integer.MAX_VALUE;
        if(dp[i]!=-1)
            return dp[i];
        for(int j=i;j<arr.length;j++)
        {
            if(b+arr[j][0]>k)
                break;
            // max = Math.min(max,a+call(arr,0,k,j+1));
            a= Math.max(a,arr[j][1]);
            max = Math.min(max,a+call(arr,k,j+1,dp));
            b+=arr[j][0];
        }
        return dp[i]=max;
       
    }
}