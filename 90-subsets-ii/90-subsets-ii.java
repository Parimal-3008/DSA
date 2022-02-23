class Solution {
    public List<List<Integer>> subsetsWithDup(int[] arr) {
        List<List<Integer>> list = new LinkedList<>();
        Arrays.sort(arr);list.add(new LinkedList<>());
        call(arr,0,list,new LinkedList<>());
        return list;
    }
    public void call(int[] arr, int i,List<List<Integer>> list , List<Integer> temp )
    {
        if(i==arr.length)
        {            
              
            return;
        }
        for(int j=i;j<arr.length;j++)
       {
           if(j>i && arr[j-1]==arr[j])
               continue;
       
        temp.add(arr[j]);
        call(arr,j+1,list,new LinkedList<>(temp));
        list.add(new LinkedList<>(temp));    
        temp.remove(temp.size()-1); 
       // list.add(new LinkedList<>(temp));
       }        
    }
}