class Solution {
    public int minimizeConcatenatedLength(String[] arr) {
        int[][][] dp= new int[arr.length+10][27][27];
        if(arr.length==1)
            return arr[0].length();
        for(int i[][]:dp)
            for(int j[]:i)
                Arrays.fill(j,-1);
        return call(arr,dp,-1,' ',' ');
    }
    public int call(String[] arr, int[][][] dp,int i, char start, char end)
    {
        if(i==arr.length)
            return 0;
        if(i==-1)
        {
            int a = Integer.MAX_VALUE;
            int len = arr[0].length();
            int len2= arr[1].length();
            int b = Integer.MAX_VALUE;
            if(arr[0].charAt(len-1) == arr[1].charAt(0))
                a = len+len2-1+ call(arr,dp,2,arr[0].charAt(0),arr[1].charAt(len2-1));
            else
                a = len+len2+ call(arr,dp,2,arr[0].charAt(0),arr[1].charAt(len2-1));
            if(arr[1].charAt(len2-1) == arr[0].charAt(0))
                b= len+len2-1+ call(arr,dp,2,arr[1].charAt(0),arr[0].charAt(len-1));
            else
                  b= len+len2+ call(arr,dp,2,arr[1].charAt(0),arr[0].charAt(len-1));
            // System.out.println(start+" "+end+" "+a+" "+b);
            return Math.min(a,b);            
        }
        if(dp[i][(int)start - 97][(int)end - 97]!=-1)
        return dp[i][(int)start - 97][(int)end - 97];
       
        int a = Integer.MAX_VALUE;
        int len = arr[i].length();
        int b = Integer.MAX_VALUE;
        if(end == arr[i].charAt(0))
            a = len-1 + call(arr,dp,i+1,start,arr[i].charAt(len-1));
        else
             a = len + call(arr,dp,i+1,start,arr[i].charAt(len-1));
        if(start == arr[i].charAt(len-1))
            b = len -1 + call(arr,dp,i+1,arr[i].charAt(0),end);
        else
             b = len + call(arr,dp,i+1,arr[i].charAt(0),end);
       
        return dp[i][(int)start - 97][(int)end - 97]=Math.min(a,b);
    }
}