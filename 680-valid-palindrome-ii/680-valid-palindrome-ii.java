class Solution {
    public boolean validPalindrome(String str) {
        int st=0;
        int l=0;int r=str.length()-1;
        while(l<r)
        {
            char ch1= str.charAt(l);
            char ch2= str.charAt(r);
            if(ch1==ch2)
            {
                l++;r--;
            }
            else
            {
                int i=l;int i1=l+1;
                int j=r;int j1=r-1;
                while(i<j1)
                {
                   if(str.charAt(i)==str.charAt(j1))
                   {
                       i++;j1--;
                   }
                    else
                        break;
                }
                if(i>=j1)
                    return true;
                while(i1<j)
                {
                   if(str.charAt(i1)==str.charAt(j))
                   {
                       i1++;j--;
                   }
                    else
                        break;
                }
                 if(i1>=j)
                    return true;
                return false;
                
            }
        }
        return true;
    }
}