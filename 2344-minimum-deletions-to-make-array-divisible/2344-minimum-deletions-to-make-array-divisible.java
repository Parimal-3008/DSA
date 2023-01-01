class Solution {
    int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    public int minOperations(int[] nums, int[] arr) {
    Arrays.sort(nums);
      if(nums[0]==1)
        return 0;
      int g = arr[0];
      for(int i=1;i<arr.length;i++)
        g = gcd(g,arr[i]);
      int c =0;
      for(int i=0;i<nums.length;i++)
      {
        if(g%nums[i]==0)
          return i;
      }
      return -1;
    }
}