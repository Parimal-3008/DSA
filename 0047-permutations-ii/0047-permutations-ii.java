class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<arr.length;i++)
        {
            if(set.contains(arr[i]))
                continue;
            set.add(arr[i]);
            List<Integer> temp = new ArrayList<>();
            temp.add(arr[i]);
            int[] st= new int[arr.length];
            st[i]=-1;
            call(arr,temp,st);
        }
        return list;
    }
    public void call( int[] arr, List<Integer> temp,int[] st)
    {
        Set<Integer> set = new HashSet<>();
        for(int k=0;k<arr.length;k++)
        {
            if(st[k]==-1)
                continue;
            if(set.contains(arr[k]))
                continue;
            st[k]=-1;
            set.add(arr[k]);
            temp.add(arr[k]);
            call(arr,new ArrayList<>(temp),st);
            st[k]=0;
            temp.remove(temp.size()-1);
        }
        int count = 0;
        for(int i:st)
            if(i==-1)count++;
        if(count==arr.length)
            list.add(temp);
    }
}