class Solution {
    public String simplifyPath(String str) {
        int n = str.length();
        if(n==1)
            return "/";
        if(str.charAt(n-1)=='/')
            str= str.substring(0,n-1);
         String str2 = "";
        char prev = str.charAt(0);
        for(int i=1;i<str.length();i++)
        {
            char ch = str.charAt(i);
            if(ch == prev && ch=='/')
            {
                
            }
            else 
           {prev = ch; str2+=String.valueOf(ch);}
        }
        // System.out.println(str2);
        String arr[]= str2.split("/");
        Stack<String> st = new Stack<>();
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i].equals(".."))
            {
                if(!st.isEmpty())
                    st.pop();
                
            }
            else if(arr[i].equals("."))
            {
                
            }
            else
                st.push(arr[i]);
        }
        String ans="";
        if(st.isEmpty())
            return "/";
        while(!st.isEmpty())
            ans= "/"+st.pop()+ans;
        return ans;
    }
}