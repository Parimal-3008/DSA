class Solution {
    public List<String> fullJustify(String[] arr, int k) {
        int curr = 0;
        int count = 0;
        int prev = 0;
        List<String> list= new ArrayList<>();
        for(int i=0;i<arr.length;i++)
        {
            curr+=arr[i].length();            
            if(curr+count>k)
            {
                curr-=arr[i].length();
                int empty= k-curr;
                int quo =0;
                int rem = 0;
               if(count == 1)
                {
                    for(int j=0;j<empty;j++)
                        arr[i-1]+=" ";
                    list.add(arr[i-1]);
                     prev = i;
                curr= arr[i].length();
                count=1;
                    continue;
                }
               
                quo = empty/(count-1);
                rem = empty%(count-1);
                
                

                String str="";
                for(int j=prev;j<i-1;j++)
                {                    
                    for(int po=0;po<quo;po++)
                        arr[j]+=" ";
                }
                for(int j=prev;j<prev+rem;j++)
                    arr[j]+=" ";
                for(int j=prev;j<i;j++)
                    str+=arr[j];
                list.add(str);
                prev = i;
                curr= arr[i].length();
                count=1;
            }
            else
                count++;
            
        }
           int empty= k-curr;
                int quo =0;
                int rem = 0;
               if(count == 1)
                {
                    for(int j=0;j<empty;j++)
                        arr[arr.length-1]+=" ";
                    list.add(arr[arr.length-1]);
                    return list;
                }
               
                
                rem = empty-count+1;
                // System.out.println(curr+" "+count+" "+rem);
                

                String str="";
                for(int j=prev;j<arr.length-1;j++)
                {                    
                     arr[j]+=" ";
                }
                for(int j=0;j<rem;j++)
                    arr[arr.length-1]+=" ";
                for(int j=prev;j<arr.length;j++)
                    str+=arr[j];
                list.add(str);
        return list;
        
    }
}