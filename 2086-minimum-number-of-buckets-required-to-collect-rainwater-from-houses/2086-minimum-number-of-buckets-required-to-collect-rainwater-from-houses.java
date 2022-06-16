class Solution {
    public int minimumBuckets(String str1) {
        if(str1.length()==1)
        {
            if(str1.charAt(0)=='H')
                return -1;
            return 0;
        }
        if(str1.length()==2)
        {
            if(str1.equals(".."))
                return 0;
            if(str1.equals("H.")||str1.equals(".H"))
                return 1;
            if(str1.equals("HH"))
                return -1;
        }
        if(str1.startsWith("HH")||str1.endsWith("HH"))
            return -1;
        int arr[] = new int[str1.length()];
         for(int i=1;i<str1.length()-1;i++)
         {
             char ch1 = str1.charAt(i);
             char ch2 =str1.charAt(i-1);
               char ch3 =str1.charAt(i+1);
             if(ch1==ch2 && ch1==ch3 && ch1=='H')
                 return -1;
             if(ch1=='.'&& ch2=='H' && ch3=='H' && arr[i-1]!=1)
             {
                 arr[i-1]=1;
                 arr[i]=2;
                 arr[i+1]=1;
             }
             
                 
         }
        int ans=0;
        for(int i=0;i<str1.length();i++)
        {
            char ch = str1.charAt(i);
            if(ch=='H' && arr[i]==0)
                arr[i]=2;
            if(arr[i]==2)
                ans++;
            
        }
        return ans;
    }
}