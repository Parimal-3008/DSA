class Solution {
    public int smallestRepunitDivByK(int k) {
      if(k%2 == 0 || k%10 == 5)
        return -1;
      int l = 1;int ans =1;
      Set<Integer> set = new HashSet<>();
      while(true)
      {
        int rem = l%k;
        if(rem == 0)
          return ans;
        if(set.contains(rem))
             return -1;
        if(rem!=l)
           l = rem;
        l = (l*10)+1;        
        ans++;
        set.add(rem);
      }
      // return -1;
        
    }
}