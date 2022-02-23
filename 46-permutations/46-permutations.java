class Solution {
    public List<List<Integer>> permute(int[] arr) {
         List<List<Integer>> list = new LinkedList<>();
         boolean vis[]= new boolean[arr.length];
        Arrays.fill(vis,false);
        call(arr,list,vis,0,new LinkedList<>());
        return list;
        
    }
    public void call(int[] arr, List<List<Integer>> list,boolean[] vis,int i, List<Integer> temp )
    {
       
          if(temp.size()==arr.length)
          {
             list.add(new LinkedList<>(temp));   
              return;
          }
        
        for(int j=0;j<arr.length;j++)
        {
            if(vis[j]) continue;
            temp.add(arr[j]);
            vis[j]=true;
            call(arr,list,vis,j+1,new LinkedList<>(temp));
            vis[j]=false;
            temp.remove(temp.size()-1);
        }
    }
}