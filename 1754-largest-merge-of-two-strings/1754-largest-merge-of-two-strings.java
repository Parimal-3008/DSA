class Solution {
    public String largestMerge(String str1, String str2) {
      String ans ="";
      int i=0;int j=0;
      if(str1.equals(str2))
      {
        return call(str1,str2);
      }
      while(i<str1.length() && j<str2.length())
      {
        char c1= str1.charAt(i);
        char c2 = str2.charAt(j);
        // boolean flag = false;
        if(c1>c2)
        {
          ans= ans+String.valueOf(c1);
          i++;
        }
        else if(c1<c2)
        {
          ans= ans+String.valueOf(c2);
          j++;
        }
        else
        {
          int i1=i+1;int j1=j+1;
          int flag = 9;
          while(i1<str1.length()|| j1<str2.length())
          {
             char c3= str1.charAt(str1.length()-1);
             char c4 = str2.charAt(str2.length()-1);
            if(i1<str1.length())
              c3=str1.charAt(i1);
            if(j1<str2.length())
              c4=str2.charAt(j1);
            
            if(c3>c4)
            {
                ans= ans+String.valueOf(c1);
                i++;
              flag = 8;
              break;
            }
            else if(c3<c4)
            {
               ans= ans+String.valueOf(c2);
               j++;
              flag = 8;
              break;
            }
            else
            {
              i1++;j1++;             
            }
          }
          if(flag == 9)
            break;
        }
       
      }
      while(i<str1.length())
      {
        ans = ans+String.valueOf(str1.charAt(i));
        i++;
      }
      while(j<str2.length())
      {
        ans = ans + String.valueOf(str2.charAt(j));
        j++;
      }
      return ans;
        
    }
  public String call(String str1,String str2)
  {
    String ans="";
     if (str1.length() == 0  || str2.length() == 0)
            return str1 + str2;
        if (str1.compareTo(str2) > 0)
            return str1.charAt(0) + call(str1.substring(1), str2);
        return str2.charAt(0) + call(str1, str2.substring(1));
  }
}