class Solution {
    public int countHighestScoreNodes(int[] parents) {
        List<List<Integer>> list = new ArrayList<>();
      List<List<Integer>> list2= new ArrayList<>();
      for(int i=0;i<parents.length;i++)
       {
        list.add(new ArrayList<>());
        list2.add(new ArrayList<>());
      }
      for(int i=1;i<parents.length;i++)
      {
        list.get(parents[i]).add(i);        
      }
      for(int i=0;i<parents.length;i++)
      {
        if(list2.get(i).isEmpty())
        { 
          int tot = call(i,list,list2);
          
        }
        
      }
     long max = 1;
      int ans2= 0;
      System.out.println(list2);
      for(int i=0;i<parents.length;i++)
      {
        long curr = 1;
        int l = 0;int r = 0;
       if(list2.get(i).size()>=1)
       {
         l=list2.get(i).get(0);
         curr*=(long)l;
       }
       if(list2.get(i).size()>=2)
       {
         r=list2.get(i).get(01);
         curr*=(long)r;
       }
        if(i!=0)
        curr*=(long)(parents.length-1-l-r);
       
        if(max<curr)
       {
          max = curr;
          ans2=1;       
       }
        else if(max == curr)
        {
          ans2++;
        }
        
      }
      System.out.println(max);
      return ans2;
      
    }
  public int call(int i,List<List<Integer>> list, List<List<Integer>> list2)
  {
      int l = 0;
    int r = 0;
    if(list.get(i).size()>0)
      l= 1 + call(list.get(i).get(0),list,list2);
    if(list.get(i).size()>1)
      r= 1 + call(list.get(i).get(1),list,list2);
    if(l>0)
      list2.get(i).add(l);
    if(r>0)
      list2.get(i).add(r);
    return l+r;
    
  }
}