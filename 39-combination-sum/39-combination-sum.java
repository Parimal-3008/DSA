class Solution {
    public List<List<Integer>> combinationSum(int[] arr, int tar) {
          List<List<Integer>> list=new LinkedList<>();
           call(arr,tar,0,list,new LinkedList<>());
        return list;
    }
    public void call(int[] arr,int tar,int n,List<List<Integer>> list,List<Integer> temp)
    {
        if(tar==0)
        {
           list.add(temp);
            return;
        }
        if(n>=arr.length||tar<0)
            return;
         call(arr,tar,n+1,list,new LinkedList<>(temp));
        temp.add(arr[n]);
        call(arr,tar-arr[n],n,list,new LinkedList<>(temp));
        
       
    }
}