class Solution {
    public double myPow(double x, int n) {
      // boolean status= false;
      //   if(n>0)
      //     status = true;
      // n= Math.abs(n);
      if(n==0)
        return 1;
      if(n==1)
      return x;
    if(n==-1)
      return 1.0/x;
    double ans = myPow(x,n/2);
    if((n-n/2)==n/2)
      return ans*ans;
     if(n<0)
       return ans*ans/x;
    return ans*ans*x;
    }
//   public double call(double x, int n)
//   {
    
    
//   }
}