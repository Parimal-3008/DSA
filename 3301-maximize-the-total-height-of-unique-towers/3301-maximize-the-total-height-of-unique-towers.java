class Solution {
    public long maximumTotalSum(int[] maximumHeight) {
        Arrays.sort(maximumHeight);
        long sum = 0;
        int prev = Integer.MAX_VALUE;
        for(int i=maximumHeight.length-1;i>=0;i--)
        {
            if(prev>maximumHeight[i])
            {
                sum+=(long)maximumHeight[i];
                prev = maximumHeight[i];
            }
            else
            {
                if(prev == 1)
                return -1;
                sum+=(long)(prev-1);
                prev = prev-1;
            }
            
        }
        return sum;
    }
}