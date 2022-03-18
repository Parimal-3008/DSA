class Solution {
    public String removeDuplicateLetters(String s) {
        /*
        we store thr freq of each char present in the string
        we check if we get an elemnt smaller than previously used elemnt
        then we have a chance of popping it as it occurs in next part hence freq array will be used
        and if we pop the element then we didnt use it so we sey it in vis as false and if it didnt             occur in next part we are bound to use it and we cant skip it.
        
        */
        int[] freq=new int[26];
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            freq[ch-'a']++;
        }
        boolean vis[]= new boolean[26];
        Stack<Character> st = new Stack();
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            freq[ch-'a']--;
            if(vis[ch-'a'])
                continue;
            while(!st.isEmpty()&&st.peek()>ch&& freq[st.peek()-'a']>0)
            {
                char c =st.pop();
                vis[c-'a']=false;
            }
            st.push(ch);
            vis[ch-'a']=true;
        }
        StringBuilder sb = new StringBuilder();
        for(char c : st) 
            sb.append(c);

        return sb.toString();
    }
}