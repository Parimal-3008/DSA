class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length()==0)
            return true;
        int j=0;char prev= s.charAt(j);
        for(int i=0;i<t.length();i++)
        {
            char ch1=t.charAt(i);
            if(ch1==prev)
            {
                j++;
                if(j==s.length())
                    return true;
                prev= s.charAt(j);
            }
        }
        return false;
    }
}