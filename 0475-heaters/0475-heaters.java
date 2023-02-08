class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        int l = 0;
      int ans = 1;
      
      Arrays.sort(houses);
      Arrays.sort(heaters);
      int r = Math.max(Math.abs(heaters[heaters.length-1]-houses[0]),Math.abs(heaters[0]-houses[houses.length-1]));
      while(l<=r)
      {
        int mid = (l+r)/2;
        if(check(mid,houses,heaters))
        {
          ans = mid;
          r = mid-1;
        }
        else 
          l = mid+1;
      }
      return ans;
    }
  public boolean check(int mid,int[] houses, int[] heaters)
  {
     int arr[][]= new int[heaters.length][2];
    TreeSet<Integer> set = new TreeSet<>();
    for(int i:heaters)
      set.add(i);
    for(int i:houses)
    {
     
      Integer p1= set.floor(i);
      Integer p2= set.ceiling(i);
      if(p1!=null)
      {
        if(Math.abs(p1-i)<=mid)
          continue;
      } 
      if(p2!=null)
      {
        if(Math.abs(p2-i)<=mid)
          continue;
      }
      return false;
    }
    return true;
    
  }
}