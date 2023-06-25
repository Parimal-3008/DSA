class Solution {
    int res = 0;
    public int longestSubsequence(int[] arr, int k) {
        
        Map<Integer,TreeSet<Integer>> mp = new HashMap<>();
        for(int i=0;i<arr.length;i++)
        {
            TreeSet<Integer> set = new TreeSet<>();
            if(mp.containsKey(arr[i]))
                set = mp.get(arr[i]);
            set.add(i);
            mp.put(arr[i],set);
        }
        int[] dp= new int[arr.length];
        Arrays.fill(dp,-1);
        int p =  call(arr,mp,0,k,dp);
        return res;
    }
    public int call(int[] arr,   Map<Integer,TreeSet<Integer>> mp , int i,int k,int[] dp)
    {
        if(i==arr.length)
            return 0;
        int ans = 1;
        if(dp[i]!=-1)
            return dp[i];
        if(mp.containsKey(arr[i]+k))
        {
            TreeSet<Integer> set = mp.get(arr[i]+k);
            if(set.higher(i)!=null)
            {
                ans = 1 + call(arr,mp,set.higher(i),k,dp);
            }
            
        }
        int ans2 = call(arr,mp,i+1,k,dp);
        res = Math.max(ans2,Math.max(ans,res));
        return dp[i]=ans;
        
        
    }
}