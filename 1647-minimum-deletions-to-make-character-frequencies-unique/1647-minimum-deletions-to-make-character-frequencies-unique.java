class Solution {
    public int minDeletions(String str) {
       int[] arr= new int[26];
        for(int i=0;i<str.length();i++)
            arr[str.charAt(i)-'a']++;
        Arrays.sort(arr);
        int ans=0;
        Set<Integer> set = new HashSet<>();
        for(int i=25;i>=0;i--)
        {
            if(arr[i]==0)
                break;
            if(!set.contains(arr[i]))
                set.add(arr[i]);
            else
            {
                while(set.contains(arr[i]) && arr[i]>0)
                   { arr[i]--;ans++;}
                set.add(arr[i]);
                
            }
        }
        return ans;
    }
}