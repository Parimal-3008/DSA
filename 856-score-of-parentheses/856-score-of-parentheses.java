class Solution {
    public int scoreOfParentheses(String s) {
        int flag=0;int score=0;
        Stack<Integer> st = new Stack();
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            // if we find open parenthesis
			// push the current score into the stack
            if(ch=='(')
            {
                st.push(score);
                score=0;
            }
            else   // if we find close parenthesis
            {
               score= st.pop()+Math.max(2*score,1);
            }

        }
        return score;
    }
}