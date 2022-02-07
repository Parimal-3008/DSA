class Solution {
    public char findTheDifference(String s, String t) {
        int char1[]= new int[26];
        int char2[] = new int[26];
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            char1[(int)ch-97]++;
        }
         for(int i=0;i<t.length();i++)
        {
            char ch = t.charAt(i);
            char2[(int)ch-97]++;
        }
        for(int i=0;i<26;i++)
        {
            if(char1[i]!=char2[i])
                return (char)(i+97);
        }
        return ' ';
    }
}