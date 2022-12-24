class Solution {
    public int calculate(String s) {
      int res = 0;
        Stack<String> st = new Stack<>();
      s="("+s+")";
      for(int i=0;i<s.length();i++)
      {
        char ch = s.charAt(i);
        if(ch==' ')
         {
          // System.out.println("EMih");
          continue;}
        if(ch!=')')
          st.push(String.valueOf(ch).trim());
        else
        {
          // System.out.println(st);
          String ans =""; int dig=0;
          while(!st.isEmpty())
          {
            String s1=st.pop();
            if(s1.equals("("))
            {
              if(!ans.equals(""))
              st.push(String.valueOf(Integer.parseInt(ans)+dig));
              else
                st.push(String.valueOf(dig));
              break;
            }
            // System.out.println(st);
            if(s1.equals("-"))
            {
              dig += Integer.parseInt(ans)*(-1);
              ans="";
            }
            else if(!s1.equals("+"))
            {
              ans = s1+ans;
            }
            else
            {
              dig += Integer.parseInt(ans);
              ans="";
            }              
          }
        }
      }
      // System.out.println(st);
      return Integer.parseInt(st.peek());
    }
}