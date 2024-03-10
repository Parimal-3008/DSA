class Solution {
    public int findValueOfPartition(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int max = Integer.MAX_VALUE;
        for(int i=1;i<n;i++)
        {
            max = Math.min(max,arr[i]-arr[i-1]);
        }
        return max;
    }
}