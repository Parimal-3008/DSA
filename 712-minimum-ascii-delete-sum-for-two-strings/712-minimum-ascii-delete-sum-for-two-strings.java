class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int dp[][]= new int[1004][1004];
            for(int i=0;i<dp.length;i++)
                for(int j=0;j<dp[0].length;j++)
                    dp[i][j]=-1;
        return call(0,0,s1,s2,dp);
    }
    
    public int call(int i, int j, String str1,String str2,int[][] dp)
    {
        if(i==str1.length())
        {
            int sum=0;
            for(int k=j;k<str2.length();k++)
                sum+=(int)str2.charAt(k);
            return sum;
        }
        if(j==str2.length())
        {
            int sum=0;
            for(int k=i;k<str1.length();k++)
                  sum+=(int)str1.charAt(k);
            return sum;
                
        }
        if(dp[i][j]!=-1)
            return dp[i][j];
        char ch1 = str1.charAt(i);
        char ch2 = str2.charAt(j);
        int a=Integer.MAX_VALUE;
        int b=Integer.MAX_VALUE;
        int c=Integer.MAX_VALUE;
        if(ch1==ch2)
            a = call(i+1,j+1,str1,str2,dp);
        //else
        {
             b= (int)ch1 + call(i+1,j,str1,str2,dp);
        c= (int)ch2 + call(i,j+1,str1,str2,dp);
        }
       
       // System.out.println(i+" "+j+" "+Math.min(a,Math.min(b,c)));
        return  dp[i][j]=Math.min(a,Math.min(b,c));

    }
}