class Solution {
    public int deleteAndEarn(int[] arr) {
        Arrays.sort(arr);
        TreeMap<Integer,Integer> mp = new TreeMap<>();
        for(int i=0;i<arr.length;i++)
        {            
            mp.put(arr[i],mp.getOrDefault(arr[i],0)+1);
        }
        int[] dp = new int[10001];
        Arrays.fill(dp,-1);
        // System.out.println(mp);
        return call(arr[0],mp,dp);
    }
    public int call(int i,TreeMap<Integer,Integer> mp,int[] dp)
    {
        if(dp[i]!=-1)
            return dp[i];
        Integer higher = mp.higherKey(i+1);
        int a = i*mp.get(i);int b = 0;
        if(higher!=null)
            a= a+ call(higher,mp,dp);
        if(mp.higherKey(i)!=null)
             b = call(mp.higherKey(i),mp,dp);
        return dp[i]= Math.max(a,b);
    }
}