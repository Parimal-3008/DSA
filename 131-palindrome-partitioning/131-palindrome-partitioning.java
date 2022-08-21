class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
      call(s,0,list,new ArrayList<>());
      return list;
    }
  public void call(String str, int ind, List<List<String>> list,List<String> l)
  {
    if(ind==str.length())
    {
      list.add(new ArrayList<>(l));
          return;
    }
   for(int i=ind;i<str.length();i++)
   {
     if(check(str,ind,i))
     {
       l.add(str.substring(ind,i+1));
       call(str,i+1,list,new ArrayList<>(l));
       l.remove(l.size()-1);
     }
   }
    
  }
  public boolean check(String str,int l , int r)
  {
    while(l<=r)
    {
      if(str.charAt(l)!=str.charAt(r))
        return false;
      l++;r--;
    }
    return true;
  }
}