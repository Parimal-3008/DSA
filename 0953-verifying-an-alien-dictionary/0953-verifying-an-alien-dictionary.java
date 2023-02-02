class Solution {
    public boolean isAlienSorted(String[] arr, String order) {
        Map<Character,Integer> mp= new HashMap<>();
      for(int i=0;i<order.length();i++)
        mp.put(order.charAt(i),i);
       for(int i=0;i<arr.length;i++)
       {
         for(int j=i+1;j<arr.length;j++)
         {
           
            for(int k=0;k<Math.min(arr[i].length(),arr[j].length());k++)
            {
              char ch1= arr[i].charAt(k);
              char ch2= arr[j].charAt(k);
              if(mp.get(ch1)>mp.get(ch2))
                return false;
              else if(mp.get(ch1)<mp.get(ch2))
                break;
              if(k ==Math.min(arr[i].length(),arr[j].length()) -1 &&  arr[j].length()<arr[i].length())
             return false;
            }
         }
       }
      return true;
    }
}