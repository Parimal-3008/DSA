class Solution {
    public String smallestSubsequence(String s) {
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