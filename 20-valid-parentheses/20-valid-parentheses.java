class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack();
        for(int i=0;i<s.length();i++)
        {
            char ch= s.charAt(i);
            if(st.isEmpty())
                st.push(ch);
            else
            {
                if(ch ==')'&& st.peek()=='(')
                    st.pop();
                else if(ch ==']'&& st.peek()=='[')
                    st.pop();
                else if(ch =='}'&& st.peek()=='{')
                    st.pop();
                else
                    st.push(ch);
            }
            
        }
        return st.isEmpty();
    }
}