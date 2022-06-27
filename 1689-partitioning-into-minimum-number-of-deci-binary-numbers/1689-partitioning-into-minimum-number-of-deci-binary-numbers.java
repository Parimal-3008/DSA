class Solution {
    public int minPartitions(String str) {
        int max =-1;
      for(int i=0;i<str.length();i++)
      {
        char ch = str.charAt(i);
        if((int)ch>max)
          max = (int)ch;
      }
      return max-48;
    }
}
// 1 2 3 
