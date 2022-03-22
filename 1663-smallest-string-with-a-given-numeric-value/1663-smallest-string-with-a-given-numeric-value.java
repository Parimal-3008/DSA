class Solution {
    public String getSmallestString(int n, int k) {
        StringBuilder str=new StringBuilder("");
        int rem=k%26;
        int q= k/26;
        for(int i=0;i<q;i++)
            str=str.append("z");
       
        if(rem!=0)
            str= str.insert(0,String.valueOf((char)(rem+96)));
        int len =str.toString().length();
        int diff= n-len;
        if(diff==0)
            return str.toString();
       // System.out.println(str);
        int i=0;
        while(diff>0)
        {
            char ch =str.charAt(i);
            int as=(int)ch;
            if(ch=='a'){
                i++;continue;}
            //System.out.println(i);
            str=str.replace(i,i+1,"a"+String.valueOf((char)(as-1)));
            diff--;
            i++;
            
        }
        return str.toString();
    }
}