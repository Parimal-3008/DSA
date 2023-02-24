class Solution {
    public boolean makesquare(int[] arr) {
      int sum =0;
      for(int i:arr)
        sum+=i;
      if(sum%4!=0)
        return false;
      Arrays.sort(arr);
      for(int i=0;i<arr.length/2;i++)
      {
        int t= arr[i];
        arr[i]=arr[arr.length-1-i];
        arr[arr.length-1-i] = t;
      }
      return call(0,0,0,0,arr,0,sum/4);
        
    }
  public boolean call(int side1,int side2, int side3,int side4, int[] arr, int i,int target)
  {
     if(side1==side2 && side2 ==side3 && side3 == side4 && i == arr.length)
      return true;
   if(i==arr.length)
      return false;
    boolean a = false;
    boolean b = false;
    boolean c = false;
    boolean d = false;
    if(side1+arr[i]<=target)
     a = call(side1+arr[i],side2,side3,side4,arr,i+1,target);
    if(side2+arr[i]<=target)
     b = call(side1,side2+arr[i],side3,side4,arr,i+1,target);
    if(side3+arr[i]<=target)
     c = call(side1,side2,side3+arr[i],side4,arr,i+1,target);
    if(side4+arr[i]<=target)
     d = call(side1,side2,side3,side4+arr[i],arr,i+1,target);
    return a || b || c ||d;
  }
}