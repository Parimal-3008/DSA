class Solution {
    public List<List<Integer>> subsets(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l2 =new ArrayList<>();
        list.add(l2);
        call(arr,0,list,new ArrayList<Integer>());
        return list;
    }
    public void call(int [] arr, int i,List<List<Integer>> list, List<Integer> l)
    {
        if(i== arr.length)
            return;
        //
        call(arr,i+1,list,new ArrayList<>(l));
        l.add(arr[i]);
        list.add(l);
        call(arr,i+1,list,new ArrayList<>(l));
        
        
    }
}