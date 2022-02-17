class Solution {
    public List<List<Integer>> combinationSum(int[] arr, int k) {
        List<List<Integer>> list = new ArrayList<>();
        
        call(list,arr,k,0,0,new ArrayList<Integer>());
        return list;
    }
    public void call(List<List<Integer>> list,int[] arr, int k, int i, int curr,ArrayList<Integer> l)
    {
        if(i== arr.length || curr>k)
            return;
        if(curr == k)
        {
            list.add(l);
            return;
        }
        call(list,arr,k,i+1,curr,new ArrayList<Integer>(l));
        l.add(arr[i]);
         call(list,arr,k,i,curr+arr[i],new ArrayList<Integer>(l));
         
    }
}