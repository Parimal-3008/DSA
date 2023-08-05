class Solution {
    List<String> list = new ArrayList<>();
    public List<String> addOperators(String str, int k) {
         StringBuilder str2 = new StringBuilder(String.valueOf(str.charAt(0)));
        call(str2,str,1,k);
        return list;
    }
    public void call(StringBuilder curr,String str, int i, int k)
    {
        if(i==str.length())
        {
            if(check(curr.toString(),k))
                list.add(curr.toString());
            return;
        }
        call(curr.append("+"+String.valueOf(str.charAt(i))),str,i+1,k);
        curr.delete(curr.length()-2,curr.length());
        call(curr.append("-"+String.valueOf(str.charAt(i))),str,i+1,k);
        curr.delete(curr.length()-2,curr.length());
        call(curr.append("*"+String.valueOf(str.charAt(i))),str,i+1,k);
        curr.delete(curr.length()-2,curr.length());
        call(curr.append(String.valueOf(str.charAt(i))),str,i+1,k);
         curr.delete(curr.length()-1,curr.length());
      
    }
    public boolean check(String str, int k)
    {
        // System.out.println(str);
        str+=" ";
        Stack<Long> st = new Stack<>();
        long prev = 0l;
        String prevstr="";
        char prevch='+';
        for(int i=0;i<str.length();i++)
        {
            char ch = str.charAt(i);
            
            if(Character.isDigit(ch))
            {
                long po = Long.parseLong(String.valueOf(ch));
                prevstr+=String.valueOf(ch);
                prev = (prev*10) +po;
            }
            else
            {
                
                if(prevstr.charAt(0)=='0'&& prevstr.length()>1)
                  {
                    // System.out.print(prevstr+":::");
                    return false;
                }
                if(prevch=='*')
                {
                    long po = st.pop();
                    st.push(po*prev);                    
                    
                }
                else if(prevch=='-')
                    st.push(0l-prev);
                else
                    st.push(prev);
                prevch = ch;
                prev = 0l;
                prevstr="";
            }
        }
        // System.out.println();
        long ans = 0;
        while(!st.isEmpty())
            ans+=st.pop();
        return ans==(long)k;
    }
}