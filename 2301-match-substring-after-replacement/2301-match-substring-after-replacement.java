class Solution {
    public boolean matchReplacement(String str1, String str2, char[][] arr) {
        Map<Character,Set<Character>> mp = new HashMap<>();
        for(int i=0;i<arr.length;i++)
         {  
            if(!mp.containsKey(arr[i][0]))
          {  
                Set<Character> set  = new HashSet<>();
                set.add(arr[i][1]);
                mp.put(arr[i][0],set);
            }
            else
            {
                Set<Character> set  = mp.get(arr[i][0]);
                set.add(arr[i][1]);
                mp.put(arr[i][0],set);
            }
               
        }
        int n1=str1.length();
        int n2=str2.length();
        for(int i=0;i<=n1-n2;i++)
        {
           
            int p=i;
            for(int j=0;j<n2;j++)
            {
                 char ch = str1.charAt(p);
                char ch2 = str2.charAt(j);
               //System.out.println(ch2);
                if(ch==ch2 ||(mp.containsKey(ch2) && mp.get(ch2).contains(ch)))
                {
                    //System.out.print(ch2);
                    p++;
                    if(j==n2-1)
                        return true;
                }
                else
                    break;                
            }            
        }
        return false;
        
        
    }
    
}