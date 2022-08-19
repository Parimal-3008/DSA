class Solution {
    public int kthGrammar(int n, int k) {
        if(k==1)
          return 0;
      if(k==2)
        return 1;
      int p = kthGrammar(n,(int)Math.ceil((double)k/2.0));
      if(k%2==0)
    {  if(p==1)
        return 0;
      else
        return 1;}
      return p;
    }
}