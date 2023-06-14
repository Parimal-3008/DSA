class Solution {
    public boolean wordBreak(String s, List<String> dict) {
         Set<String> set = new HashSet<>();
        for(String i: dict)
            set.add(i);
        int dp[][]= new int[400][400];
        for(int i[]:dp)
            Arrays.fill(i,-1);
       return call(set,0,1,s,dp)==0;
    }
    public int call(Set<String> set, int prev, int i, String str,int[][] dp)
    {
        if(i==str.length())
        {
            String temp = str.substring(prev,i);
            if(set.contains(temp))
                return 0;
            return i-prev;
                
        }
        if(dp[prev][i]!=-1)
            return dp[prev][i];
        int a = call(set,prev,i+1,str,dp);
        int b = str.length();
         int c = i-prev+call(set,i,i+1,str,dp);
        if(set.contains(str.substring(prev,i)))
        {
            b = call(set,i,i+1,str,dp);           
        }
        return dp[prev][i]=Math.min(a,Math.min(b,c));
    }
}