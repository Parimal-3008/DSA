class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] left, int[] right) {
      
      Set<Integer> set = new HashSet<>();
      for(int i=0;i<n;i++)
        set.add(i);
      for(int i:left)
      {
        if(i==-1)
          continue;
         if(set.contains(i))
           set.remove(i);
      }
      for(int i:right)
      {
        if(i==-1)
          continue;
         if(set.contains(i))
           set.remove(i);
      }
      if(set.size()!=1)
        return false;
      int root=-1;
      for(int i:set)
        root= i;
      boolean vis[]= new boolean[n];
      Arrays.fill(vis,false);
      boolean p = call(root,left,right,vis);
      if(p==false)
        return p;
      int count =0;
      for(boolean i:vis)
      {
        if(i)
          count++;
      }
      return count == n;
        
    }
  public boolean call(int i, int[] left, int[] right, boolean[] vis)
  {
    if(i == -1)
      return true;
    if(vis[i])
      return false;
    vis[i] = true;
    
    boolean a = call(left[i],left,right,vis);
    // if(right[i]!=-1)
     boolean b = call(right[i],left,right,vis);
    return a&b;
  }
}