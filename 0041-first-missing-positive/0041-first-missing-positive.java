class Solution {
    public int firstMissingPositive(int[] arr) {
        int count =0;
      for(int i:arr)
      {
        if(i==1)
          count++;
      }
      if(count ==0)
        return 1;
      for(int i=0;i<arr.length;i++)
      {
        if(arr[i]>arr.length|| arr[i]<1)
          arr[i]=1;        
      }
      for(int i=0;i<arr.length;i++)
      {
        int p = arr[i];
        if(p<0)
          p*=(-1);
        p--;
        if(arr[p]>0)
          arr[p]*=(-1);
      }
      for(int i=0;i<arr.length;i++)
      {
        if(i!=0 && arr[i]>0)
          return i+1;
      }
      return arr.length+1;
     
     
    }
}