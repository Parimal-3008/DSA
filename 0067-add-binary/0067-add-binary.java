class Solution {
    public String addBinary(String str1, String str2) {
        int i=str1.length()-1;
      int j = str2.length()-1;
      char carry = '0';
      String ans="";
      while(i>=0 && j>=0)
      {
        char c1 = str1.charAt(i);
        char c2 = str2.charAt(j);
        if(c1=='1' && c2=='1')
        {
          if(carry=='0')
          {
            carry='1';
            ans = "0"+ans;
          }
          else
          {
             carry='1';
            ans = "1"+ans;
          }
        }
        else if(c1=='0' && c2=='0')
        {
           if(carry=='1')
           {
             carry='0';
              ans = "1"+ans;
           }
          else
            ans = "0" + ans;
        }
        else
        {
          if(carry=='0')
          {
            ans="1"+ans;
          }
          else
          {
            
            ans="0"+ans;
          }
        }
        i--;j--;
      }
      while(i>=0)
      {
        char c1 = str1.charAt(i);
        if(c1=='0')
        {
          if(carry=='1')
          {
            carry ='0';
            ans= "1"+ans;
          }
          else
            ans = "0"+ans;
        }
        else
        {
          if(carry=='1')
            ans="0"+ans;
          else
            ans="1"+ans;
        }
        i--;
      }
      while(j>=0)
      {
        char c1 = str2.charAt(j);
        if(c1=='0')
        {
          if(carry=='1')
          {
            carry ='0';
            ans= "1"+ans;
          }
          else
            ans = "0"+ans;
        }
        else
        {
          if(carry=='1')
            ans="0"+ans;
          else
            ans="1"+ans;
        }
        j--;
      }
      if(carry=='1')
        ans="1"+ans;
      return ans;
    }
}