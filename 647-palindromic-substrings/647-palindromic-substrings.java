class Solution {
    public int countSubstrings(String str) {
        int ans  = 01;//str.length();
        for(int i=1;i<str.length();i++)
        {
            ans+= call(str,i-1,i);
            ans+= call(str,i,i);
        }
        return ans;
    }
    public int call(String str,int i, int j)
    {
        int ans=0;
        while(i>=0&& j<str.length())
        {
            char ch1 = str.charAt(i);
            char ch2 = str.charAt(j);
            if(ch1 == ch2)
            {
                ans++;
                i--;
                j++;
            } 
            else 
                return ans;
        }
        return ans;        
}
}