class Solution {
    public List<String> generateParenthesis(int n) {
       List<String> list = new LinkedList<>();
        call(list,n,n,"");
        return list;
        
    }
    public void call(List<String> list, int n, int m,String curr)
    {
        if(n==0&&m==0)
        {
            if(!curr.equals("")&&check(curr))
                list.add(curr);
            return;
        }
        if(n!=0)
            call(list,n-1,m,curr+")");
        if(m!=0)
            call(list,n,m-1,curr+"(");
    }
    public boolean check(String str)
    {
        Stack<Character> st= new Stack<>();
        for(int i=0;i<str.length();i++)
        {
            char ch = str.charAt(i);
            if(st.size()==0)
            {st.push(ch);}
            else
            {
               char c = st.peek();
                if(ch==')'&&c == '(')
                   st.pop();
                else
                    st.push(ch);
            }
            
        }
        if(st.size()>0)
            return false;
        return true;

    }
}