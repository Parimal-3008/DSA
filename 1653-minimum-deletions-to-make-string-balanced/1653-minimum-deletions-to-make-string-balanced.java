class Solution {
    public int minimumDeletions(String str) {
        int a[]= new int[str.length()];
        int b[]= new int[str.length()];
            int a1=0;int b1=0;
        for(int i=0;i<a.length;i++)
        {
            if(str.charAt(i)=='a')
                a1++;
            else
                 b1++;
            a[i]=a1;
            b[i]=b1;
        }
        int min = Math.min(a1,b1);
        for(int i=0;i<str.length();i++)
        {
            int la= a[i];
            int ba= b[i];
            int ra= a1-a[i];
            int rb= b1-b[i];
            int ans = ba+ra;
            min = Math.min(ans,min);
        }
        return min;
    }
}