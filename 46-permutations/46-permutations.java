class Solution {
    public List<List<Integer>> permute(int[] arr) {
         List<List<Integer>> list = new LinkedList<>();
        call(arr,list,0);
        return list;
        
    }
    public void call(int[] arr, List<List<Integer>> list,int i)
    {      
          if(i==arr.length)
          {
              List<Integer> l = new LinkedList<>();
             for(int j:arr)
                 l.add(j);
              list.add(l);
              return;
          }       
        for(int j=i;j<arr.length;j++)
        {
            swap(arr,i,j);
            call(arr,list,i+1);
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