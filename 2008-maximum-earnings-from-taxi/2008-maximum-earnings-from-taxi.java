class Solution {
    public long maxTaxiEarnings(int n, int[][] arr) {
        Arrays.sort(arr, new Comparator<int[]>(){
            public int compare(int[] o1,int[] o2)
            {
               int res=Integer.compare(o1[0],o2[0]);
                if(res==0)
                {
                    res= Integer.compare(o1[1],o2[1]);
                    if(res==0)
                        res= Integer.compare(o1[2],o2[2]);
                }
                return res;
            }
        });
        long dp[] = new long[arr.length];
       // for(int i=0;i<arr.length;i++)
            Arrays.fill(dp,-1);
         // for(int i=0;i<arr.length;i++)
         //     System.out.println(arr[i][0]+" "+arr[i][1]);
        // return 1;
        return call(0,arr,dp);
    }
    public long call(int i,int[][] arr, long[] dp)
    {
        if(i==arr.length)
            return 0;
        long a =0;
        if(dp[i]!=-1)
            return dp[i];
         long b = call(i+1,arr,dp);
      
        int p = i+1;
        int q = arr.length-1;
        int ans =arr.length;
        
        while(p<=q)
        {
            int mid = (p+q)/2;
           
            if(arr[mid][0]>=arr[i][1])
            {
                ans = mid;
                q=mid-1;
            }
            else
                p = mid+1;
        }        
         a= (long)(arr[i][1]-arr[i][0]+arr[i][2])+call(ans,arr,dp);        
        return dp[i]=Math.max(a,b);
    }
}