class Solution {
    public String decodeString(String s) {
        int i[]={0};
        // s="1["+s+"]";
        return call(s.toCharArray(),i);
    }
    public String call(char[] arr, int[] i)
    {
        String word="";
        String num="";
        int no = 1;
        for(;i[0]<arr.length;i[0]++)
        {
            if(Character.isLetter(arr[i[0]]))
                word+=String.valueOf(arr[i[0]]);
            else if(arr[i[0]]=='[')
            {
                i[0]++;
                String rus = call(arr,i);
                no = Integer.parseInt(num);
                
                for(int j=0;j<no;j++)
                    word+=rus;
                // System.out.println(word+" "+no);
                num="";
                no=1;
            }
            else if(arr[i[0]]==']')
            {
                // i[0]++;
                // System.out.println(word);
                return word;
            }
            else if(Character.isDigit(arr[i[0]]))
                num+=String.valueOf(arr[i[0]]);
        }
        
        return word;

    }
}