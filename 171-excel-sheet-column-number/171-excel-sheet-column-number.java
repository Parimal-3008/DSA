class Solution {
    public int titleToNumber(String str) {
        int j=0;int res=0;
        while(j<str.length())
        {
            char ch = str.charAt(str.length()-1-j);
            int p = (int)ch -64;
            res+=((int)Math.pow(26,j)*p);
            j++;
        }
        return res;
    }
}