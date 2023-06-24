class Solution {
    public int atMostNGivenDigitSet(String[] digits, int k) {
        int [] arr= new int[digits.length];
        for(int i=0;i<arr.length;i++)
            arr[i]=Integer.parseInt(digits[i]);
        String str = String.valueOf(k);
        int len = str.length();
         int[][][] dp= new int[2][100][2];
        for(int i[][]:dp)
            for(int j[]:i)
                Arrays.fill(j,-1);
        int ans = call(arr,k,1,len,1,0,dp)-1;
       // System.out.println(ans);
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]<Integer.parseInt(String.valueOf(str.charAt(0))))
            ans+=call(arr,k,0,len,1,0,dp);
            else if(arr[i]==Integer.parseInt(String.valueOf(str.charAt(0))))
                 ans+=call(arr,k,0,len,1,1,dp);
        }
        return ans;
    }
    public int call(int[] arr, int k, int iszero,int len, int i,int equal,int[][][] dp)
    {
        if(i==len)
            return 01;
        if(dp[iszero][i][equal]!=-1)
            return dp[iszero][i][equal];
         String str = String.valueOf(k);
        if(iszero==1)
        {
            int ans = call(arr,k,1,len,i+1,0,dp);
            int ans2= 1;
            for(int j=i;j<len;j++)
            {
                ans2*=(arr.length);
            }
            return dp[iszero][i][equal] = ans+ans2;
        }
        else
        {
            if(equal!=1)
            {
                 int ans2= 1;
            for(int j=i;j<len;j++)            
                ans2*=(arr.length);
                // System.out.println(i+" "+ans2);
                return dp[iszero][i][equal] = ans2;            
            }
            else
            {
                int ans = 0;
                for(int j=0;j<arr.length;j++)
                {
                    int ans2 = 0;
                    if(arr[j]<Integer.parseInt(String.valueOf(str.charAt(i))))
                        ans2=call(arr,k,0,len,i+1,0,dp);
                    else if(arr[j]==Integer.parseInt(String.valueOf(str.charAt(i))))
                        ans2=call(arr,k,0,len,i+1,1,dp);
                    else
                        break;
                    System.out.println(ans2);
                    ans+=ans2;
                }
                return dp[iszero][i][equal] = ans;
            }
        }
    }
}