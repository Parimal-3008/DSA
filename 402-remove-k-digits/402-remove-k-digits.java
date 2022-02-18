class Solution {
    public String removeKdigits(String num, int k) {
        char arr[]=num.toCharArray();
        Stack<Character> st=new Stack<>();
        st.push(arr[0]);
        for(int i=01;i<num.length();i++)
        {
            while(!st.isEmpty()&&st.peek()>arr[i]&&k>0){
                st.pop();k--;}
            st.push(arr[i]);
        
        }
        while(k-->0)
        {
            st.pop();
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty())
            sb.append(st.pop());
        sb.reverse();
        
        //remove all the 0 at the head
        while(sb.length()>1 && sb.charAt(0)=='0')
            sb.deleteCharAt(0);
        if(sb.toString().equals(""))
            return "0";
        return sb.toString();
    }
}