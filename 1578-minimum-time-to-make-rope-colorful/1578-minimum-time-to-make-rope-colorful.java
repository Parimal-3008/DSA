class Solution {
    public int minCost(String str, int[] arr) {
        int ans = 0;
        int curr= arr[0];
        str+=" ";
        char prev = str.charAt(0);
        int max = arr[0];
        for(int i=1;i<str.length();i++)
        {
            char ch = str.charAt(i);
            if(prev == ch)
            {
                curr+=arr[i];
                max = Math.max(max,arr[i]);
            }
            else
            {
                // System.out.println(i+" "+max+" "+curr);
                 ans+=(curr-max);
                    if(i!=str.length()-1)
                   { 
                        curr=arr[i];
                        max=arr[i];
                   }
                    prev = ch;
                
            }
        }
        return ans;
    }
}