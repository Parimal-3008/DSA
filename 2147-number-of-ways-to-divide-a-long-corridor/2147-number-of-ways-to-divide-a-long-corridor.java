class Solution {
    public int numberOfWays(String str) {
      Map<Integer,Integer> mp = new HashMap<>();
      int last = 1;
      // mp.put(0,0);
      for(int i=0;i<str.length();i++)
      {
        char ch = str.charAt(i);
        if(ch=='S'){
          mp.put(last,i+1);
          last++;
        }
      }
      if(last%2==0 || last==1)
        return 0;
      // if(last == 3)
      //   return 1;
      // mp.put(last,str.length()+1);
      // System.out.println(mp);
      int prev =0;
      long ans = 1;
      // List<Integer> list = new ArrayList<>();
      for(int i=1;i<(last+1)/2;i++)
      {
        int a = 2*i;
        int b = a+1;
        if(!mp.containsKey(b))
          break;
        long diff = mp.get(b) - mp.get(a);
        ans = (ans*diff)%1000000007;
      }
      return (int)ans;
      
      
        
    }
}