class Solution {
    public int eraseOverlapIntervals(int[][] arr) {
        Arrays.sort(arr,new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b)
            {
                int res = Integer.compare(a[1],b[1]);
                if(res == 0)
                    res = Integer.compare(a[0],b[0]);
                return res;                
            }
        });
        int p1 = arr[0][1];int p2 = arr[0][1];
        int ans = 0;
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i][0]<p2)
                ans++;
            else
            {
                p1= arr[i][0];
                p2 = arr[i][1];
            }
        }
        return ans;
        
    }
}