class Solution {
    public String countAndSay(int n) {
        return call(1,"1",n);
    }
    public String call(int i, String str, int n)
    {
        if(i==n)
            return str;
        StringBuilder obj = new StringBuilder("");
        char prev =str.charAt(0);
        int count =1;
        str+=" ";
        for(int j=1;j<str.length();j++)
        {
            char ch = str.charAt(j);
            if(ch==prev)
                count++;
            else
            {
                obj.append(String.valueOf(count));
                obj.append(String.valueOf(prev));
                
                prev=ch;
                count = 1;
            }
        }
        return call(i+1,obj.toString(),n);
        
    }
}