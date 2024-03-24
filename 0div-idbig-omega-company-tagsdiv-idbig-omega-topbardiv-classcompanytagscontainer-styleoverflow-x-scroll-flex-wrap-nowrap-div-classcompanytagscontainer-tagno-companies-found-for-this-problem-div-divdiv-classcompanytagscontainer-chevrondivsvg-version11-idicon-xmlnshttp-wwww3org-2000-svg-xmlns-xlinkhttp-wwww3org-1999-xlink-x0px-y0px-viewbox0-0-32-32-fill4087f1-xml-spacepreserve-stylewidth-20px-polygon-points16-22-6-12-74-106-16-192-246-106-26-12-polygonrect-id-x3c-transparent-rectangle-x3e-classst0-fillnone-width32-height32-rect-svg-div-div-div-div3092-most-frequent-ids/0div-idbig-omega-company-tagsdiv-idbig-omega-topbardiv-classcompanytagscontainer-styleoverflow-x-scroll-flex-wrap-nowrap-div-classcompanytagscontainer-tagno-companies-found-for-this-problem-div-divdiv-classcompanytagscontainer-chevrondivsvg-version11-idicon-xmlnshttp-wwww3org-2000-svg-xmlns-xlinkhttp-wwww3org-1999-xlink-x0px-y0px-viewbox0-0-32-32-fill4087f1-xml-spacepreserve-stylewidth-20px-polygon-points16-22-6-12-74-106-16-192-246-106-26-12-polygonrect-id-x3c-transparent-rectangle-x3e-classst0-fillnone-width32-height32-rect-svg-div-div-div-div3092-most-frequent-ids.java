class Solution {
    public long[] mostFrequentIDs(int[] arr, int[] freq) {
        TreeMap<Long, TreeSet<Integer>> mp = new TreeMap<>();
        int n = arr.length;
        long dp[]= new long[100001];
        long[] ans = new long[n];
        for(int i=0;i<n;i++)
        {
          if(dp[arr[i]]!=0)
            {
              TreeSet<Integer> set  = mp.get(dp[arr[i]]);
                set.remove(arr[i]);
                if(!set.isEmpty())
                mp.put(dp[arr[i]],set);
                else
                    mp.remove(dp[arr[i]]);
            }
           TreeSet<Integer> set = new TreeSet<>();
            dp[arr[i]]+=freq[i];
            if(mp.containsKey(dp[arr[i]]))
                set = mp.get(dp[arr[i]]);
            set.add(arr[i]);
            mp.put(dp[arr[i]], set);
            ans[i]=mp.lastKey();
        }
        return ans;
    }
}