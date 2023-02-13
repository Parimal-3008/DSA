class Solution {
    public int countOdds(int l, int h) {
        int odd =0;int even=0;
      if(h-l==1)
        return 1;
      if(l%2==0)
        even++;
      else
        odd++;
      if(h%2==0)
        even++;
      else
        odd++;
      if(odd!=0)
        return ((h-l)/2)+1;
      
        return (h-l)/2;
       
    }
}