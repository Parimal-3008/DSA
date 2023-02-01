class Solution {
  
    public int maxUniqueSplit(String s) {
         Set<String> set = new HashSet<>();
      return call(0,0,set,"",s);
    }
  public int call(int i, int prev, Set<String> set, String curr, String str)
  {
    if(i== str.length())
    {
      
      if(!set.contains(curr))
        set.add(curr);
      if(set.contains(""))
        set.remove("");
      return set.size();
    }
    char ch = str.charAt(i);
   
    int b = call(i+1,prev,new HashSet<>(set),curr+String.valueOf(ch),str);
    set.add(curr);
     int a = call(i+1,i,new HashSet<>(set),String.valueOf(ch),str);
    return Math.max(a,b);
  }
}