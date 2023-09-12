class Solution {
    public int gcd( int a , int b)
    {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    public int maxScore(int[] arr) {
        char cp[]= new char[arr.length];
        String str="";
        for(int i=0;i<arr.length;i++)
            str+="1";
        int len = Integer.parseInt(str,2);
        int[] dp = new int[len];
        Arrays.fill(dp,-1);
        Arrays.fill(cp,'0');
        return call(arr,1,cp,dp);
        }
    public int call(int[] arr, int i, char[] st,int[] dp)
    {
        String str = String.valueOf(st);
         // System.out.println(i+" "+str);
        if(i-1 ==arr.length/2)
            return 0;
        int max = 0;
       int len = Integer.parseInt(str,2);
        if(dp[len]!=-1)
            return dp[len];
        for(int p=0;p<arr.length;p++)
        {
            if(st[p]=='1')
                continue;
            for(int q=p+1;q<arr.length;q++)
            {
                if(st[q]=='1')
                    continue;
                st[p]='1';
                st[q]='1';
                
                int temp = (i*gcd(arr[p],arr[q]))+ call(arr,i+1,st,dp);
                // System.out.println(p+" "+q+" "+temp);
                max = Math.max(max,temp);
                st[p]='0';
                st[q]='0';               
            }
        }
        // System.out.println(str+" "+max);
        return dp[len]=max;
    }
}