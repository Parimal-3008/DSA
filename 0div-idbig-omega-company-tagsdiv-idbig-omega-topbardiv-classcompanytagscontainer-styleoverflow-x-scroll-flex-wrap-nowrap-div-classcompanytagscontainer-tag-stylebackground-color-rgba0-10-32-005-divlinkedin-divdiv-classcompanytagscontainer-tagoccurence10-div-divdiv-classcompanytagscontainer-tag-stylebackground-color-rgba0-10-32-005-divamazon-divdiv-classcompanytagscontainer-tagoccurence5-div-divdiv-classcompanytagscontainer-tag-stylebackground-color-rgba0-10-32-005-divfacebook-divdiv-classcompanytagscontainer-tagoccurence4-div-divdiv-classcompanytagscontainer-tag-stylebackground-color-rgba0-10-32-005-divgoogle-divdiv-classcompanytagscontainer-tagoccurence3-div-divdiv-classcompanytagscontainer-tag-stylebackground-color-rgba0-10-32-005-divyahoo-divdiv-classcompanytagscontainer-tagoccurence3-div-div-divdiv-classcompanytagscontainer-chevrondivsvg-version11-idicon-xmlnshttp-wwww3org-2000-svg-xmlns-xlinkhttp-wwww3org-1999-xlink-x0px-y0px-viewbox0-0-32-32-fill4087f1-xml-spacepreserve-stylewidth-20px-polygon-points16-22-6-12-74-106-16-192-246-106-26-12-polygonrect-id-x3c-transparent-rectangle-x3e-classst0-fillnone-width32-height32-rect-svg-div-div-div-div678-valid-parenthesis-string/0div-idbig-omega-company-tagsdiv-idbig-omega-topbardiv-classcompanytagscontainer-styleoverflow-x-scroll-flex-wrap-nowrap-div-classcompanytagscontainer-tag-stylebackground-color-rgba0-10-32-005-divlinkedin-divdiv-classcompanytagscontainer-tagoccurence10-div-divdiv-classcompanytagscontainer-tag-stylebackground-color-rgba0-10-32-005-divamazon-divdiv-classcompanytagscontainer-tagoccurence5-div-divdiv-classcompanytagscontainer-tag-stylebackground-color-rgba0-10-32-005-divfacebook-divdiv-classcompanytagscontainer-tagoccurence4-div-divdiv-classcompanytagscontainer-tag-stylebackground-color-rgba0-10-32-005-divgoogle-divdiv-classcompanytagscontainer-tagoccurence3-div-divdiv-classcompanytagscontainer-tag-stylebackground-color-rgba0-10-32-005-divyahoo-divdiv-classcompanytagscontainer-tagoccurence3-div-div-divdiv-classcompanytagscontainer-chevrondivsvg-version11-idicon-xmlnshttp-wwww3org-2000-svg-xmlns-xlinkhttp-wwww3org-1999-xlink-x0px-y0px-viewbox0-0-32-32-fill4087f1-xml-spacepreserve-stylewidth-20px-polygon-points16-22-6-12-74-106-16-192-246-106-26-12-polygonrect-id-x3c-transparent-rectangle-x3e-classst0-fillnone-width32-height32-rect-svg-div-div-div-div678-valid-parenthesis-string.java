class Solution {
    public boolean checkValidString(String str) {
        int dp[][]= new int[str.length()][str.length()];
        for(int i[]:dp)
            Arrays.fill(i,-1);
        return call(str,0,0,dp)>0;
    }
    public int call(String str, int i, int val,int[][] dp)
    {
        if(i==str.length())
        {
             return val==0?1:0;
        }
        if(val<0)
            return 0;
        if(dp[i][val]!=-1)
            return dp[i][val];
        char ch = str.charAt(i);
        if(ch=='(')
           {
            return dp[i][val] = call(str,i+1,val+1,dp);
           }
        else if(ch==')')
           {
                      
            return dp[i][val] = call(str,i+1,val-1,dp);
        }
        else
        {
            int a = call(str,i+1,val+1,dp);
            int b = call(str,i+1,val-1,dp);
            int c = call(str,i+1,val,dp);
            return dp[i][val]=a+b+c;
        }
        
    }
}