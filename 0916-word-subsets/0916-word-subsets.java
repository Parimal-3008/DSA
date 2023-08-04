class Solution {
    public List<String> wordSubsets(String[] words1, String[] arr2) {
        int[] dp1= new int[26];
        for(String i:arr2)
        {
            int[] dp2= new int[26];
            for(int j=0;j<i.length();j++)
            {
                char ch = i.charAt(j);
                dp2[ch-'a']++;
            }
            for(int j=0;j<26;j++)
            {
                dp1[j]=Math.max(dp1[j],dp2[j]);
            }
        }
        List<String> ans = new ArrayList<>();
        for(String i:words1)
        {
            int[] dp2= new int[26];
             for(int j=0;j<i.length();j++)
            {
                char ch = i.charAt(j);
                dp2[ch-'a']++;
            }
            boolean flag = true;
            for(int j=0;j<26;j++)
            {
                if(dp1[j]>dp2[j])
                {
                    flag = false;
                    break;
                }
            }
            if(flag)
                ans.add(i);
        }
        return ans;
    }
}