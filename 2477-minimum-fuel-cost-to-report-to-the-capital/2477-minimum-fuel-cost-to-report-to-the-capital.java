class Solution {
  class car
  {
    long no;long travel;
    public  car(long no, long travel)
    {
      this.no = no;
      this.travel = travel;
    }
    
  }
    public long minimumFuelCost(int[][] arr, int k) {
      int n = arr.length;
      List<List<Integer>> list = new ArrayList<>();
      for(int i=0;i<=n;i++)
        list.add(new ArrayList<>());
      for(int i=0;i<n;i++)
      {
        list.get(arr[i][0]).add(arr[i][1]);
        list.get(arr[i][1]).add(arr[i][0]);
      }
      boolean vis[]= new boolean[n+1];
      Arrays.fill(vis,false);
      return dfs(0,list,k,vis).travel;
        
    }
  public car dfs(int i, List<List<Integer>> list , int k,boolean[] vis)
  {
      if(vis[i])
        return new car(0,0);
    vis[i]=true;
   
    car temp =new car(1,0);
    for(int j:list.get(i))
    {
       if(!vis[j])
       {
         car t = dfs(j,list,k,vis);
         temp.no +=t.no;
         temp.travel += t.travel;
       }
         
    }
    if(i!=0)
    temp.travel += (long)Math.ceil((double)temp.no/(double)k) ;
    // System.out.println(i+";"+(temp.no)+";"+(temp.travel));
    return new car(temp.no, temp.travel);
  }
  
}