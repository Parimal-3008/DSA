class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] arr) {
        // for(int i=0;i<arr.length;i++)4
        Arrays.sort(arr);
        call(0,arr,new ArrayList<>());
        list.add(new ArrayList<>());
        return list;
    }
    public void call(int i, int[] arr, List<Integer> temp)
    {
        if(i==arr.length)
        {
            return;
        }
        Set<Integer> set = new HashSet<>();
        for(int j=i;j<arr.length;j++)
        {
            if(set.contains(arr[j]))
                continue;
            set.add(arr[j]);
            temp.add(arr[j]);
            call(j+1,arr,new ArrayList<>(temp));            
            list.add(new ArrayList<>(temp));
            
            temp.remove(temp.size()-1);
        }
        // call(i+1,arr,new ArrayList<>(temp));
    }
}