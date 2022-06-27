class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> list = new ArrayList<>();
      List<Integer> l1 = new ArrayList<>();
      l1.add(1);
      List<Integer> l2 = new ArrayList<>();
      list.add(new ArrayList<>(l1));
      for(int i=0;i<n-1;i++)
      {       
          l2.add(1);
          for(int j=0;j<l1.size()-1;j++)
          {
            l2.add(l1.get(j)+l1.get(j+1));
          }
          l2.add(1);
          list.add(new ArrayList<>(l2));
          l1= new ArrayList<>(l2);
        l2 = new ArrayList<>();
        
      }
      // if(n!=1)
      // list.add(l1);
      return list;
    }
}