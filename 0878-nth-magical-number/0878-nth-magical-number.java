class Solution {
   public long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    public int nthMagicalNumber(int n, int a, int b) {
        long lcm = ((long)a*(long)b)/gcd((long)a,(long)b);
      long l = (long)Math.min(a,b);
      long r = Long.MAX_VALUE-l;
      long ans=0;
      while(l<=r)
      {
        long mid = (l+r)/2;
        long h = check(mid,(long)a,(long)b,lcm);
        // System.out.println(l+" "+r+" "+mid+" "+h);
        if(h>(long)n)
        r= mid-1;
        else if(h<(long)n)
          l= mid+1;
        else
        { 
          if(mid%a==0 || mid%b == 0)
          {
            ans = mid;
            break;
          }
          else
          {
            r=mid;
          }
        }
      }
      return (int)(ans%1000000007);
    }
  public long check(long mid,long a,long b,long lcm)
  {
      long ans = mid/a;
    ans+=(mid/b);
    ans-=(mid/lcm);
    return ans;
  }
}