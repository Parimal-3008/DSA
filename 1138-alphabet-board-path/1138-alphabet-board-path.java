class Solution {
    public String alphabetBoardPath(String str) {
      //  Map<Character,Integer[]> mp = new HashMap<>();
      
      String ans="";
      char prev = 'a';
      for(int i=0;i<str.length();i++)
      {
        char ch = str.charAt(i);
        int p2 =(int)ch - 97;
        int c2 = p2/5;
        int r2 = p2 % 5;
        if(ch==prev)
        {
          ans = ans+"!";
          continue;
        }
        if(prev == 'z')
        {
          prev='u';
          ans = ans + 'U';
            
        }
        int p1 = (int)prev - 97;
        int c1 = p1/5;
        int r1 = p1 % 5;
        
         for(int j=0;j<Math.abs(r1-r2);j++)
        {
          if(r1>r2)
            ans = ans+"L";
          else 
            ans = ans+"R";
        }
       for(int j=0;j<Math.abs(c1-c2);j++)
       {
            if(c1<c2)
              ans = ans+"D";
             else
               ans = ans+"U";
       }
       
        prev = ch;
        ans = ans+"!";
      }
      return ans;
      // return ans;
    }
}