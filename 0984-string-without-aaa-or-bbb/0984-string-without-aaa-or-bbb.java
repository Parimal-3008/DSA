class Solution {
    public String strWithout3a3b(int a, int b) {
        String str="";
      char prev=' ';
      if(a-b>=2)
      {
        prev='a';
        str+="aa";
        a-=2;
      }
      else if(b-a>=2)
      {
        prev='b';
        str+="bb";
        b-=2;
      }
      else
      {
        if(a>b)
        {
          str+="a";a--;prev='a';
        }
        else
        {
          str+="b";b--;prev='b';
        }
      }
      while(a>0 && b>0)
      {
        if(prev=='a')
        {
           if(b>a && b>=2)
           {
             str+="bb";b-=2;
           }
          else
          {
            str+="b";b--;
          }
          prev='b'; 
        }
        else
        {
          if(a>b && a>=2)
           {
             str+="aa";a-=2;
           }
          else
          {
            str+="a";a--;
          }
          prev='a'; 
        }
      }
      if(prev=='a')
      {
        if(b==2)
          str+="bb";
        else if(b==1)
          str+="b";
      }
      else
      {
        if(a==2)
          str+="aa";
        else if(a==1)
          str+="a";
      }
      return str;
      
    }
}