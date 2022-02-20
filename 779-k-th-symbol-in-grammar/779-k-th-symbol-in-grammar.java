class Solution {
    public int kthGrammar(int n, int k) {
       int p=call(n,k);
       return  p;
    }
    public int call(int n,int k )
    {
        if(k==1)
           return 0;
        if(k==2)
            return 1;
        int q=0;
        if(k>(int)Math.pow(2,n-2))
        {
            int k1=-(int)Math.pow(2,n-2) + k;
            q = call(n-1,k1);
        }
        else
            { q = call (n-1,k);return q;}
        
        if(q==1)
            return 0;
        return 1;
    }
   
}