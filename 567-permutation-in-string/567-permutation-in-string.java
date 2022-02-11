class Solution {
    public boolean checkInclusion(String str1, String str2) {
        int ch1[]= new int[26]; int ch2[]= new int[26];
        if(str1.length()>str2.length())
            return false;
        for(int i=0;i<str1.length();i++)
        {
            char ch =str1.charAt(i);
            ch1[(int)ch - 97]++;
             char c2 =str2.charAt(i);
            ch2[(int)c2 - 97]++;
        }
        boolean st = check(ch1,ch2);
        if(st)
            return st;
        for(int i=str1.length();i<str2.length();i++)
        {
            char ch = str2.charAt(i);
             ch2[(int)ch - 97]++;
            char c2= str2.charAt(i-str1.length());
             ch2[(int)c2 - 97]--;
            st = check(ch1,ch2);
             if(st)
            return st;
        }
        return false;
    }
     public boolean check(int arr1[], int arr2[])
     {
         for(int i=0;i<26;i++)
         {
             if(arr1[i]>arr2[i])
                 return false;
         }
         return true;
     }
}