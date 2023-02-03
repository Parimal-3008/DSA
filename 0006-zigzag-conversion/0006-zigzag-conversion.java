class Solution {
    public String convert(String str, int k) {
      if(k==1)
        return str;
        char arr[][]= new char[k+1][str.length()+1];
      for(char i[]:arr)
        Arrays.fill(i,'!');
      String st="DOWN";
      int p1=0;int p2=0;
      for(int i=0;i<str.length();i++)
      {
        char ch = str.charAt(i);
        if(st.equals("DOWN"))
        {
          arr[p1][p2]=ch;
          p1++;
        }
        else if(st.equals("UP"))
        {
          arr[p1][p2]=ch;
          p1--;p2++;
        }
        
        if(p1==k)
        {
          p1-=2;p2++;
          st="UP";
        }
        else if(p1==-1)
        {
          p1=1;st="DOWN";
        }
        
      }
      String ans ="";
      for(int i=0;i<arr.length;i++)
      {
        for(int j=0;j<arr[0].length;j++)
        {
          if(arr[i][j]!='!')
            ans = ans+String.valueOf(arr[i][j]);
        }
      }
      return ans;
    }
}