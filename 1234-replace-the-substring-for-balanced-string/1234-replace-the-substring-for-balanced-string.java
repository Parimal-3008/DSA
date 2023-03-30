class Solution {
    public int balancedString(String s) {
      int q = 0;
      int e =0;
      int w=0;
      int r = 0;
      for(char i:s.toCharArray())
      {
        if(i=='Q')
          q++;
        if(i=='E')
          e++;
        if(i=='W')
          w++;
        if(i=='R')
          r++;
      }
      int req = s.length()/4;
      q-=req;
      e-=req;
      w-=req;
      r-=req;
      int l = 1;
      int r2 = s.length();
      int ans = 0;
      if(q==0 && w==0 && e ==0 && r==0)
        return 0;
      Set<Character> set = new HashSet<>();
      if(q<0)
         q=0;
      if(w<0)
         w=0;
      if(e<0)
        e=0;
      if(r<0) 
        r = 0;
     
      while(l<=r2)
      {
        int mid = (l+r2)/2;
        if(check(mid,s.toCharArray(),q,e,w,r))
        {
          // System.out.println("ghj");
          ans = mid;
          r2 = mid-1;
        }
        else
          l= mid+1;
      }
      return ans;
    }
  public boolean check(int mid, char[] arr, int q,int e, int w, int r)
  {
     // System.out.println(q+" "+w+" "+e+" "+r+" "+mid);
    
    for(int i=0;i<mid;i++)
    {
      if(arr[i]=='Q')
        q--;
      if(arr[i]=='E')
        e--;
      if(arr[i]=='W' )
        w--;
      if(arr[i]=='R')
        r--;
      if(q<=0 && e<=0 && w<=0 && r<=0)
      return true;
    }
    if(q<=0 && e<=0 && w<=0 && r<=0)
      return true;
    for(int i=mid;i<arr.length;i++)
    {
    
        if(arr[i-mid]=='Q')
          q++;
        if(arr[i-mid]=='W')
          w++;
        if(arr[i-mid]=='E')
          e++;
        if(arr[i-mid]=='R')
          r++;
       if(arr[i]=='Q')
          q--;
        if(arr[i]=='W')
          w--;
        if(arr[i]=='E')
          e--;
        if(arr[i]=='R')
          r--;
      
      if(q<=0 && e<=0 && w<=0 && r<=0)
      return true;
    }
    return false;
  }
}