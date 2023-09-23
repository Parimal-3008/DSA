class Solution {
    public int longestStrChain(String[] arr) {
        Arrays.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String s1,String s2)
            {
                if(s1.length()>s2.length())
                    return 1;
                else if(s1.length()<s2.length()) 
                    return -1;
                return 0;
            }
        });
        int dp[][] = new int[arr.length][arr.length+1];
        for(int i=0;i<dp.length;i++)
            Arrays.fill(dp[i],-1);
        return call(0,-1,arr,dp);
    }
    public int call(int i, int j, String arr[],int[][] dp)
    {
        if(i==arr.length)
            return 0;
        if(dp[i][j+1]!=-1)
            return dp[i][j+1];
        int a = 0;
        if(j==-1)
        {
             a = 1+ call(i+1,i,arr,dp);
        }
        if(j!=-1&&check(arr[i],arr[j]))
        {
           // System.out.println(arr[i] +" "+arr[j]);
            a = 1+ call(i+1,i,arr,dp);
        }
        int b = call(i+1,j,arr,dp);
        return dp[i][j+1]=Math.max(a,b);
    }
    public boolean check(String str2,String str1)
    {
        int i =0;int flag=0;
        int j =0;
        if(str1.length()==str2.length())
            return false;
        while(i<str1.length() && j<str2.length())
        {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(j);
            if(ch1==ch2)
            {
                i++;j++;
            }
            else
            {
                if(flag==3)
                    return false;
                flag=3;
                j++;
            }
        }
        if(i==str1.length()&&j==str2.length())
            return true;
        if(flag==0)
        {
            if(j==str2.length()-1)
                return true;
            
        }
        return false;
        
    }
}