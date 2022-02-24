class Solution {
    public List<List<Integer>> permuteUnique(int[] arr) {
        Arrays.sort(arr);
        Set<List<Integer>> set= new HashSet<>();
         List<List<Integer>> list = new LinkedList<>();
       call(arr,list,0,set);
        System.out.println(list.size());
        return list;
        
    }
    public void call(int[] arr, List<List<Integer>> list,int i, Set<List<Integer>> set)
    {      
          if(i==arr.length)
          {
              List<Integer> l = new LinkedList<>();
             for(int j:arr)
                 l.add(j);
              if(!set.contains(l))
              {
                  list.add(l);
                  set.add(l);
              }
              
              return;
          }       
        for(int j=i;j<arr.length;j++)
        {
            if(j>i && (arr[j]==arr[i] || arr[j]==arr[j-1]))
                continue;
            
            swap(arr,i,j);
           
            call(arr,list,i+1,set);
             swap(arr,i,j);
        }
    }
    public void swap(int arr[],int i, int j)
    {
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}