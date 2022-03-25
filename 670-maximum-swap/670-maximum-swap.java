class Solution {
    public int maximumSwap(int num) {
        String str= String.valueOf(num);int max= num;
       for(int i=0;i<str.length();i++)
       {
           for(int j=i+1;j<str.length();j++)
           {
                StringBuilder str1= new StringBuilder(str);
               char c1=str.charAt(i);   char c2=str.charAt(j);
               str1= str1.replace(i,i+1,String.valueOf(c2));
               str1=str1.replace(j,j+1,String.valueOf(c1));
               int temp =  Integer.parseInt(str1.toString());
               //System.out.println(temp);
               max=Math.max(max,temp);
           }
       }
       
        return max;
    }
}