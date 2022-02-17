class Solution {
    public List<List<Integer>> combinationSum(int[] arr, int k) {
        List<List<Integer>> list = new ArrayList<>();
        Map<ArrayList<Integer> , Integer> mp = new HashMap();
        call(mp,arr,k,0,0,new ArrayList<Integer>());
        for (Map.Entry<ArrayList<Integer> , Integer> entry : mp.entrySet())
            list.add(entry.getKey());
        return list;
    }
public void call(Map<ArrayList<Integer>,Integer> mp,int[] arr,int k,int i,int curr,ArrayList<Integer> l)
    {
        if(i== arr.length || curr>k)
            return;
        if(curr == k)
        {
            
            Collections.sort(l);
            if(!mp.containsKey(l))
                mp.put(l,1);
            return;
        }
        call(mp,arr,k,i+1,curr,new ArrayList<Integer>(l));
        l.add(arr[i]);
         call(mp,arr,k,i,curr+arr[i],new ArrayList<Integer>(l));
         call(mp,arr,k,i+1,curr+arr[i],new ArrayList<Integer>(l));
    }
}