class Solution {
    public String simplifyPath(String str) {
        int n = str.length();
        
        if(str.charAt(n-1)=='/')
            str=str.substring(0,n-1);
        String str2="";
        if(str.length()==0)
            return "/";
        char prev=str.charAt(0);
        for(int i=1;i<str.length();i++)
        {
            char ch = str.charAt(i);
            if(ch==prev&&ch=='/')
            {
                
            }
            else
            {
                prev=ch;
                str2+= String.valueOf(str.charAt(i));
            }
               
        }
        String[] arr= str2.split("/");
       Stack<String> st= new Stack<>();
        
        for(int i=0;i<arr.length;i++)
        {
           if(arr[i].equals(".."))
           {
               if(st.size()>0)
                   st.pop();
           }
            else if(arr[i].equals("."))
            {
                
            }
            else
                st.push(arr[i]);
        }
        String str3="";
        while(st.size()>0)
            str3=("/"+st.pop())+str3;
        if(str3.equals(""))
            return "/";
        return str3;
    }
}