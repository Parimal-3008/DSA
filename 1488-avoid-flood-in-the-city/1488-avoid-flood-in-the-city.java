class Solution {
    public int[] avoidFlood(int[] arr) {
        int n = arr.length;
        Map<Integer,Integer> mp = new HashMap<>();
        int[] ans = new int[n];
        TreeSet<Integer> set = new TreeSet<>();
        Arrays.fill(ans,-1);
        
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==0)
            {
                set.add(i);
            }
            else if(!mp.containsKey(arr[i]))
            {
                mp.put(arr[i],i);
            }
            else
            {
                Integer a= set.higher(mp.get(arr[i]));
                // System.out.println(i+" "+set);
                if(a==null )
                   return new int[]{};
                    set.remove(a);
                ans[a]=arr[i];
                 mp.put(arr[i],i);
                
            }
            // System.out.println(i+" "+set);
        }
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==0 && ans[i]==-1)
                ans[i]=1;
        }
        return ans;
    }
}