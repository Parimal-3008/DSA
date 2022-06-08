class Solution {
    Map<Integer,Integer> mp = new HashMap<>();
    public boolean canCross(int[] arr) {
       // Set<Integer> set = new HashSet<>();
        
        for(int i=0;i<arr.length;i++)
            mp.put(arr[i],i);
       int dp[][] = new int [arr.length][3000];
        for(int i=0;i<dp.length;i++)
        Arrays.fill(dp[i],-1);
        return call(1,1,arr,dp,arr.length-1);
    }
    
    public boolean call(int i,int k, int[] arr,int[][] dp,int n)
    {
        
        if(i==arr[n])
            return true;
        if(i>arr[n] || i<=0 || !mp.containsKey(i))
            return false;
        int ind= mp.get(i);
        if(dp[ind][k]!=-1)
        {
            if(dp[ind][k]==1)
                return true;
            return false;
        }
         boolean a =false, b=false,c=false;
        if(k!=1)
        a = call(i+k-1,k-1,arr,dp,n);
         b = call(i+k+1,k+1,arr,dp,n);
         c = call(i+k  ,k  ,arr,dp,n);
        //System.out.println(i+" "+k+" "+(a|b|c));
        if(a|b|c )
            dp[ind][k]=1;
        else
            dp[ind][k]=0;
        return a|b|c;
        
    }
    public boolean check(int search, int[] arr)
    {
        int i=0;
        int j = arr.length-1;
        while(i<=j)
        {
            int mid = (i+j)/2;
            if(arr[mid]==search)
                return true;
            else if(arr[mid]>search)
                j=mid-1;
            else
                i=mid+1;
        }
        return false;
        
    }
}