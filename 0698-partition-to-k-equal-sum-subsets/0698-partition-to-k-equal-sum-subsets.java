class Solution {
    public boolean canPartitionKSubsets(int[] arr, int k) {
        int sum =0;
      for(int i:arr)
        sum+=i;
      if(sum%k!=0)
        return false;
      Arrays.sort(arr);
      return call(arr,0,new int[arr.length],sum/k,k,0);
    }
  public boolean call(int[] arr, int curr, int[] status,int req,int k,int j)
  {
    if(k==0)
    {
      if(curr==0)
        return true;
      return false;
    }
    for(int i=j;i<arr.length;i++)
    {
      if(status[i]==1)
        continue;
      
      if(curr+arr[i]<req)
      {
        status[i]=1;
        if(call(arr,curr+arr[i],status,req,k,i+1))
          return true;
        status[i]=0;
      }
      else if(curr+arr[i]==req)
      {
        status[i]=1;
        if(call(arr,0,status,req,k-1,0))
          return true;
          status[i]=0;
      }
    }
    return false;
  }
}