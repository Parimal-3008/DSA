class Solution {
    public List<List<Integer>> findSubsequences(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
      Set<String> set = new HashSet<>();
       call(0,arr,new ArrayList<>(),list,-100000,set);
      return list;
    }
  public void call(int i, int[] arr, List<Integer> temp, List<List<Integer>> list,int prev,Set<String> set)
  {
    if(i==arr.length)
    {
      String str="";
      for(int j:temp)
        str+=" "+String.valueOf(j);
      if(temp.size()>=2 && !set.contains(str)){
        list.add(temp);set.add(str);}
      return;
    }
    if(arr[i]<prev)
      call(i+1,arr,new ArrayList<>(temp),list,prev,set);
    else
    {
       call(i+1,arr,new ArrayList<>(temp),list,prev,set);
      temp.add(arr[i]);
      call(i+1,arr,new ArrayList<>(temp),list,arr[i],set);
      
    }
  }
}