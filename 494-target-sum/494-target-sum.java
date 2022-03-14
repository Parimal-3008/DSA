class Solution {
    public int findTargetSumWays(int[] arr, int k) {
        return call(arr,k,0,0);
    }
    public int call(int[] arr, int k, int curr, int i)
    {
        if(i==arr.length)
           {
              if(curr==k)
                  return 1;
            return 0;
           }
        int p = call(arr,k,curr+arr[i],i+1);
        int q = call(arr,k,curr-arr[i],i+1);
        return p+q;
    }
}