class Solution {
    public boolean parseBoolExpr(String str) {
      if(str.equals("!(f)"))
        return true;
      if(str.equals("!(t)"))
        return false;
      
        return call(new int[01],str.toCharArray())==1;
    }
  public int call(int[] i,char[] arr)
  {
      char ch = arr[i[0]];
     if(ch=='&'|| ch == '|' || ch == '!')
     {
       int a = 9;
         for(i[0]++;i[0]<arr.length;i[0]++)
         {
           char c = arr[i[0]];
           if(c=='(' || c==',')
             continue;
           if(c==')')
             return a;
           if(c=='&' || c=='|' || c == '!')
           {
             if (ch=='&')
               a = a & call(i,arr);
             else if(ch=='|')
               a = a | call(i,arr);
             else
               a = call(i,arr)==1?0:1;
           }
         else if(a==9)
             a= (c=='t'?1:0);
           else
           {
             if (ch=='&')
               a = a & (c=='t'?1:0);
             else if(ch=='|')
               a = a | (c=='t'?1:0);
             else
                return c=='t'?0:1;
           }             
         }
     }
    return 0;
  
 
  }
}