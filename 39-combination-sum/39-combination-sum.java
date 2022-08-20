class Solution {
    public List<List<Integer>> combinationSum(int[] arr, int k) {
        List<List<Integer>> list  = new ArrayList<>();
        call(arr,k,0,list,new ArrayList<>());
      return list;
    }
  public void call(int[] arr, int k, int i,  List<List<Integer>> list, List<Integer> l)
  {
    if(k==0)
    {
        list.add(new ArrayList<>(l));
      return;
    }
    if(k<0 || i == arr.length)
      return;
    call(arr,k,i+1,list,new ArrayList<>(l));
    l.add(arr[i]);
    call(arr,k-arr[i],i,list,new ArrayList<>(l));
    
  }
}