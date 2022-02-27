class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> list = new LinkedList<>();
        call(list,graph,"0",0);
        return list;        
    }
    public void call( List<List<Integer>> list,int[][] arr, String str,int curr)
    {
        if(curr == arr.length-1)
        {
            String[] s= str.split(" ");
            List<Integer> temp = new LinkedList<>();
            for(String i:s)
               { 
                temp.add(Integer.parseInt(i));}
            list.add(temp);
            return;
        }
        for(int i:arr[curr])
        {
            call(list,arr,str+" "+i,i);
        }
    }
}