class Solution {
    public double myPow(double x, int n) {
        double res=1.0;
        
        if(n==-2147483648)
                {
        n/=2;
            x*=x;
        }
        if(n>0)
        {
             while(n>0)
           {
            if(n%2!=0)
            {
                res*=(double)x;
            }
            x=x*x;
            n/=2;
           }
        return res;

        }
        else if(n<0)
        {
            n*=(-1);
            
             while(n>0)
           {
            if(n%2!=0)
            {
                res/=(double)x;
            }
            x=x*x;
            n/=2;
           }
            if(res==1)
                res/=x;
        return res;
        }
       
            return 1.0;
       
    }
}