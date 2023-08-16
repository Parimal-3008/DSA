class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
         call(1,n,k,new ArrayList<>());
        return list;
    }
    public void call(int i, int n, int k, List<Integer> temp)
    {
        if(k==0)
        {
            if(!temp.isEmpty())
            list.add(temp);
            return;
        }
        if(i==n+1)
            return;
        call(i+1,n,k,new ArrayList<>(temp));
        temp.add(i);
        call(i+1,n,k-1,temp);
        // temp.remove(temp.size()-1);
        
            
    }
}