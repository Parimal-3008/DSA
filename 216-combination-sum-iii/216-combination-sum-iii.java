class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        call(1,k,n,list,new ArrayList<>());
      return list;
    }
  public void call(int i, int k, int n, List<List<Integer>> list , List<Integer> l)
  {
    if(k==0 && n==0)
    {
      list.add(l);return;
    }
    if(k<0||n<0||i>9)
      return;
    call(i+1,k,n,list,new ArrayList<>(l));
    l.add(i);
    call(i+1,k-1,n-i,list,new ArrayList<>(l));
  }
}