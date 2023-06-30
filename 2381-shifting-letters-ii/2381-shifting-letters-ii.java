class Solution {
    public String shiftingLetters(String str, int[][] shifts) {
        int arr[]= new int[str.length()+1];
         for(int i[]:shifts)
        {
             if(i[2]==1)
           { 
                 arr[i[0]]+=1;
            arr[i[1]+1]-=1;
           }
             else
             {
                  arr[i[0]]-=1;
            arr[i[1]+1]+=1;
             }
        }
        for(int i=1;i<arr.length;i++)
            arr[i]=arr[i-1]+arr[i];
        for(int i=0;i<str.length();i++)
        {
            int p  = ((int) str.charAt(i)) - 97;
            arr[i]= (arr[i]+p)%26;
            if(arr[i]<0)
                arr[i]+=26;
             
        }
        String str2="";
        for(int i=0;i<str.length();i++)
        {
           
            str2 = str2 + ((char)(arr[i]+97));
        }
        return str2;
        
    }
}