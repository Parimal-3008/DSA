class Solution {
    public int trap(int[] arr) {
        int n = arr.length;
        int[] l = new int[n];
        // Arrays.fill(l,-1);
        int[] r = new int[n];
        // Arrays.fill(r,n);
        int max = -1;
        for(int i=0;i<n;i++)
        {
            max = Math.max(max,arr[i]);
            l[i]=max;
        }
        max = -1;
         for(int i=n-1;i>=0;i--)
        {
            max = Math.max(max,arr[i]);
            r[i]=max;
        }
        int water[]= new int[n];
        int sum = 0;
        for(int i=0;i<n;i++)
        {
            water[i]= Math.min(l[i],r[i])-arr[i];
            sum+=water[i];
        }
        return sum;
    }
}