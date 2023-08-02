class Solution {
    public int maximumUniqueSubarray(int[] arr) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        int curr = 0;int j=0;
        for(int i=0;i<arr.length;i++)
        {
            if(!set.contains(arr[i]))
            {
                curr+=arr[i];
                set.add(arr[i]);
                ans = Math.max(ans,curr);
            }
            else
            {
                while(set.contains(arr[i]))
                {
                    set.remove(arr[j]);                    
                    curr-=arr[j];
                    j++;
                    ans = Math.max(ans,curr);
                }
                curr+=arr[i];
                set.add(arr[i]);
                ans = Math.max(ans,curr);
               
            }
            // System.out.println(curr);
             ans = Math.max(ans,curr);
        }
        return ans;
    }
}