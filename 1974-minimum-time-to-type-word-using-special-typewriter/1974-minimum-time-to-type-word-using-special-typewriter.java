class Solution {
    public int minTimeToType(String str) {
        int res=0;char prev='a';
        for(int i=0;i<str.length();i++)
        {
            char ch = str.charAt(i);
            int p1= Math.abs(ch-prev);
            int p2= (26-Math.abs(ch-prev));
            res+=Math.min(p1,p2);
            //System.out.println(p1+" "+p2);
            res++;
                prev=ch;
        }
        return res;
    }
}