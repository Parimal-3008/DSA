import java.math.BigInteger;

class Solution {
    public boolean splitString(String str) {
        boolean res = false;
        for(int p=1;p<=str.length()-1;p++)
        {
            res = res || call(str,p,p,str.substring(0,p));
        }
        return res;
    }
    public boolean call(String str, int prev, int i, String prev_str)
    {
        
          String str2= str.substring(prev,i+1);
           BigInteger n1 = new BigInteger(prev_str);
           BigInteger n2 = new BigInteger(str2);
           boolean temp = (n1.subtract(n2)).equals(new BigInteger("1"));
         System.out.println(n1+" "+n2);
        if(i==str.length()-1)
          return temp;
       
        boolean a = call(str,prev,i+1,prev_str);        
       if(temp )
        {
            boolean b = call(str,i+1,i+1,str2);
            return a||b;
        }
        return a;
        
    }
}