class Solution {
     List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] arr, int k) {
        Arrays.sort(arr);
        call(0,arr,k,new ArrayList<>());
        return list;
    }
    public void call(int i,int[] arr, int k, List<Integer> temp)
    {
        if(k<0)
            return;
        if(k==0)
        {
            list.add(temp);
            return;
        }
        if(i==arr.length)
            return;
        Set<Integer> set = new HashSet<>();
        for(int j=i;j<arr.length;j++)
        {
            if(set.contains(arr[j]))
                continue;
            set.add(arr[j]);
            temp.add(arr[j]);
            call(j+1,arr,k-arr[j],new ArrayList<>(temp));
            temp.remove(temp.size()-1);
        }
        

    }
}