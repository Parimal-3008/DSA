class Solution {
    public List<Integer> largestDivisibleSubset(int[] arr) {
        Arrays.sort(arr);
        
        int max =-1;
        List<Integer>[] dp = new ArrayList[arr.length+10];

            Arrays.fill(dp,new ArrayList<>());
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<arr.length;i++)
        {            
            List<Integer> li = call(i,arr,dp);
           // System.out.println(li);
            if(li.size()>max)
            {
                max =li.size();
                ans = li;
            }
        }
       // Syste
        // for(int i=0;i<dp.length;i++)
        //     System.out.println(Arrays.asList(dp[i]));
        return ans;
    }
    public List<Integer> call(int i, int[] arr, List<Integer>[] dp )
    {
       if (i== arr.length)
           return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        if(dp[i].size()!=0)
            return dp[i];
        for(int j=i+1;j<arr.length;j++)
        {
            if((arr[j]%arr[i])==0)
            {
                    
                List<Integer> temp = call(j,arr,dp);
                if(temp.size()>ans.size())
                {
                    ans = new ArrayList<>(temp);
                }                
            }

        }
        ans.add(arr[i]);
        return dp[i]=new ArrayList<>(ans);
    }       
    
}