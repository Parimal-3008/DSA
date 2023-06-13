class Solution {
    public int minSwaps(String str) {
        int n = str.length();
        String str1="";
        String str2="";
        
        for(int i=0;i<n;i++)
        {
            if(i%2==0)
            {
                str1+="0";
                str2+="1";
            }
            else
            {
                str1+="1";
                str2+="0";
            }
        }
      int c1 =0;
        int c2=0;
        int o=0;int z=0;
        for(int i=0;i<n;i++)
        {
            char ch1 = str.charAt(i);
            char ch2 = str1.charAt(i);
            char ch3 = str2.charAt(i);
            if(ch1!=ch2)
                c1++;
            if(ch1!=ch3)
                c2++;
            if(ch1=='0')
                z++;
            else
                o++;
        }
        if(Math.abs(z-o)>1)
            return -1;
        if(z>o)
            return c1/2;
        else if(z<0)
            return c2/2;
       if(c1%2!=0)
           return c2/2;
        else if(c2%2!=0)
            return c1/2;
        return Math.min(c1/2,c2/2);
        
    }
}