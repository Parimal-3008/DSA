class Solution {
    public boolean canCross(int[] arr) {
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<arr.length;i++)
            mp.put(arr[i],i);
        int dp[][]= new int[arr.length+2][arr.length+2];
        for(int[] i:dp)
            Arrays.fill(i,-1);
        return call(0,0,arr,mp,dp)>0;
    }
    public int call(int i,int prevjump,int[] arr,Map<Integer,Integer> mp,int[][] dp)
    {
        if(i==arr.length-1)
            return 1;
        if(dp[i][prevjump]!=-1)
            return dp[i][prevjump];
        int a = 0;int b = 0; int c = 0;
        if(prevjump>1 && mp.containsKey(arr[i]+prevjump-1))
            a = call(mp.get(arr[i]+prevjump-1),prevjump-1,arr,mp,dp);
        if(prevjump>0 && mp.containsKey(arr[i]+prevjump))
            b = call(mp.get(arr[i]+prevjump),prevjump,arr,mp,dp);        
        if(mp.containsKey(arr[i]+prevjump+1))
            c = call(mp.get(arr[i]+prevjump+1),prevjump+1,arr,mp,dp);
        return dp[i][prevjump]= ((a|b|c) == 1)?1:0;
    }
}