class Solution {
    public int removePalindromeSub(String s) {
        if(check(s))
            return 1;
        return 2;
    }
    public boolean check(String str)
    {
        int i=0;int j = str.length()-1;
        while(i<j)
        {
            if(str.charAt(i)!=str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}