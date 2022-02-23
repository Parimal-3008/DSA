class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new LinkedList<>();
        call(1,k,n,new LinkedList<>(),list);
        return list;
    }
    public void call(int i,int k,int n, List<Integer> temp, List<List<Integer>> list  )
    {
        if(k==0&&n==0)
        {
            list.add(temp);
            return;

        }
        if(k==10||n<0)
            return;
        for(int j=i;j<=9;j++)
        {
            if(n<j)
                return;
            temp.add(j);
            call(j+1,k-1,n-j,new LinkedList<>(temp),list);
            temp.remove(temp.size()-1);
        }
        
    }
}