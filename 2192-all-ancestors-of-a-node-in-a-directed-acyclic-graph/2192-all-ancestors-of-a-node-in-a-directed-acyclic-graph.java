class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
      //  List<Set<Integer>> list = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            graph.add(new ArrayList<>());
            list.add(new  ArrayList<>());
        }
        for(int i[]:edges)
            graph.get(i[0]).add(i[1]);
        
        for(int i=0;i<n;i++)
        {
                call(i,i,graph,list);
        }
       
            return list;
    }
    public void call(int i, int j, List<List<Integer>> graph,List<List<Integer>> list)
    {
        for(int p:graph.get(j))
        {
            if(list.get(p).size()==0||list.get(p).get(list.get(p).size()-1)!=i)
            {   list.get(p).add(i);
                call(i,p,graph,list);}
        }
        
           
    }
}