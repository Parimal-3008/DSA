class Solution {
    public int beautifulSubsets(int[] arr, int k) {
      Arrays.sort(arr);
        return call(0,arr,k,new HashSet<>())-1;
    }
  public int call(int i, int[] arr, int k, HashSet<Integer> set)
  {
    if(i==arr.length)
    {
      // System.out.println(set);
      return 1;}
    int a = call(i+1,arr,k,set);
    if(set.contains(arr[i]+k) || set.contains(arr[i]-k))
      return a;
    set.add(arr[i]);  
    int  b = call(i+1,arr,k,set);
    set.remove(arr[i]);
   
    return a + b;
  }
}