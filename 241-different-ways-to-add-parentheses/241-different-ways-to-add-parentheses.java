class Solution {
    public List<Integer> diffWaysToCompute(String str) {
        //List<Integer> l= new LinkedList<>();
        List<Integer>[][] dp = new LinkedList[40][40];
        for(int i=0;i<dp.length;i++)
            for(int j=0;j<dp[0].length;j++)
                dp[i][j]=null;
        return call(0,str.length()-1,str,dp);
        
    }
    public List<Integer> call(int start, int end, String str,List<Integer>[][] dp)
    {
                List<Integer> l2= new LinkedList<>();

        if(start>end)
            return l2;
        if(start==end-1)
          {
            if(Character.isDigit(str.charAt(start))&&Character.isDigit(str.charAt(start+1)))
            {
                l2.add(Integer.parseInt(str.substring(start,end+1)));
            return l2;
            }
        }
        else if(start==end)
        {
            l2.add(Integer.parseInt(str.substring(start,end+1)));
            return l2;
        }
        if(dp[start][end]!=null)
            return dp[start][end];
        int ans=0;
        for(int i=start+1;i<=end-1;i++)
        {
            char ch =str.charAt(i);
            if(ch=='+'||ch=='-'||ch=='*')
            {
               List<Integer> a1 = call(start,i-1,str,dp);
            List<Integer> b1 = call(i+1,end,str,dp);
            
            for(int a:a1)
                for(int b:b1)
            {
                    if(ch=='+')
                ans = a+b;
            else if(ch == '-')
                ans = a-b;
            else if(ch == '*')
                ans  = a*b;
            l2.add(ans);
                }
                 
            }
            
            
        }
        return dp[start][end] = l2;
    }
}