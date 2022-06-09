class Solution {
    public int mincostTickets(int[] arr, int[] costs) {
        // Map<Integer,Integer> mp = new HashMap<>();
        // for(int i=0;i<arr.length;i++)
        //     mp.put(arr[i],i);
        int dp[] = new int[400];
        Arrays.fill(dp,-1);
        return call(arr[0],arr,costs,dp);
    }
    //i will denote my day not array index
    public int call(int i, int[] arr, int[] cost,int[] dp)
    {
        
        int t =findceil(i,arr);
        if(t==-1)
            return 0;
        i = arr[t];
        if(dp[i]!=-1)
            return dp[i];
        int a = cost[0]+ call(i+1,arr,cost,dp);
        int b = cost[1]+ call(i+7,arr,cost,dp);
        int c = cost[2]+ call(i+30,arr,cost,dp);
        return dp[i]=Math.min(a,Math.min(b,c));
        
    }
    public int findceil(int k, int[] arr)
    {
        if(arr[arr.length-1]<k)
            return -1;
        if(k<arr[0])
            return 0;
        int res=0;
        int i=0; int j= arr.length-1;
        while(i<=j)
        {
            int mid =(i+j)/2;
            if(arr[mid]==k)
                return mid;
            if(arr[mid]<k)
            {
                i=mid+1;
            }
            else
                {
                j=mid-1;
                res=mid;
                }
        }
        return res;
    }
}