class Solution {
    public List<List<Integer>> combinationSum2(int[] arr, int k) {
        List<List<Integer>> list = new ArrayList<>();
      Arrays.sort(arr);
        
          call(0,arr,k,list,new ArrayList<>());
      return list;
    }
  public void call(int ind, int[] arr, int k, List<List<Integer>> list, List<Integer> l )
  {
     if(k==0)
    {
       list.add(l);
      return;
    }
     if(k<0 || ind == arr.length)
       return;
    for(int i=ind;i<arr.length;i++)
    {
        if(i>ind && arr[i]==arr[i-1])
          continue;
     
      l.add(arr[i]);
      call(i+1,arr,k-arr[i],list,new ArrayList<>(l));
      l.remove(l.size()-1);
    }
   
  }
}